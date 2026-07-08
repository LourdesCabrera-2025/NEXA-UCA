package sv.uca.nexauca.presentation.screens.productivity

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.models.ActividadRecienteItem
import sv.uca.nexauca.data.repositories.api.ProductividadApiRepository
import sv.uca.nexauca.data.repositories.impl.ProductividadRepositoryImpl
import sv.uca.nexauca.data.services.auth.AuthService
import sv.uca.nexauca.presentation.core.components.cards.EstadisticaCard
import sv.uca.nexauca.presentation.core.components.filters.EstadoActividad
import sv.uca.nexauca.presentation.core.components.tables.GrupoFechaActividad
import sv.uca.nexauca.presentation.core.state.ResultState
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale
import sv.uca.nexauca.data.mappers.toActividadReciente

data class HistorialUiState(
    val isLoading: Boolean = true,
    val estadisticas: List<EstadisticaCard> = emptyList(),
    val grupos: List<GrupoFechaActividad> = emptyList(),
    val query: String = "",
    val estadoSeleccionado: EstadoActividad = EstadoActividad.TODAS,
    val errorMessage: String? = null
)

class HistorialActividadesViewModel : ViewModel() {

    private val repository: ProductividadApiRepository = ProductividadRepositoryImpl()
    private val authService = AuthService()

    private var actividadesCompletas: List<ActividadRecienteItem> = emptyList()

    private val _uiState = MutableStateFlow(HistorialUiState())
    val uiState = _uiState.asStateFlow()

    init {
        cargarDatos()
    }

    fun cargarDatos() {
        val uid = authService.currentUser()?.uid
        if (uid == null) {
            _uiState.value = _uiState.value.copy(
                isLoading = false,
                errorMessage = "No hay sesión activa"
            )
            return
        }

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true, errorMessage = null)

            when (val result = repository.getTodasActividades(uid)) {
                is ResultState.Success -> {
                    actividadesCompletas = result.data
                    recalcular()
                }
                is ResultState.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = result.message
                    )
                }
                is ResultState.Loading -> Unit
            }
        }
    }

    fun onQueryChange(query: String) {
        _uiState.value = _uiState.value.copy(query = query)
        recalcular()
    }

    fun onEstadoSelected(estado: EstadoActividad) {
        _uiState.value = _uiState.value.copy(estadoSeleccionado = estado)
        recalcular()
    }

    private fun recalcular() {
        val query = _uiState.value.query
        val estado = _uiState.value.estadoSeleccionado

        val filtradas = actividadesCompletas.filter { item ->
            val coincideTexto = query.isBlank() ||
                    item.title.contains(query, ignoreCase = true) ||
                    item.projectName.contains(query, ignoreCase = true)

            val coincideEstado = when (estado) {
                EstadoActividad.TODAS -> true
                EstadoActividad.APROBADAS -> item.approved
                EstadoActividad.PENDIENTES -> !item.approved
                EstadoActividad.RECHAZADAS -> false // no existe este estado en la base todavía
            }

            coincideTexto && coincideEstado
        }

        val aprobadas = actividadesCompletas.count { it.approved }
        val pendientes = actividadesCompletas.count { !it.approved }

        val estadisticas = listOf(
            EstadisticaCard(
                icono = Icons.Filled.CheckCircle,
                colorIcono = Color(0xFF16A34A),
                fondoIcono = Color(0xFFDCFCE7),
                valor = aprobadas.toString(),
                etiqueta = "Aprobadas\nHoras completas"
            ),
            EstadisticaCard(
                icono = Icons.Filled.HourglassBottom,
                colorIcono = Color(0xFFD97706),
                fondoIcono = Color(0xFFFEF3C7),
                valor = pendientes.toString(),
                etiqueta = "Pendientes\nSolicitudes"
            ),
            EstadisticaCard(
                icono = Icons.Filled.CalendarMonth,
                colorIcono = Color(0xFF2563EB),
                fondoIcono = Color(0xFFDBEAFE),
                valor = actividadesCompletas.size.toString(),
                etiqueta = "Total\nRegistradas"
            )
        )

        val grupos = agruparPorFecha(filtradas)

        _uiState.value = _uiState.value.copy(
            isLoading = false,
            estadisticas = estadisticas,
            grupos = grupos
        )
    }

    private fun agruparPorFecha(items: List<ActividadRecienteItem>): List<GrupoFechaActividad> {
        return items
            .toActividadReciente()
            .zip(items) { actividadReciente, original -> actividadReciente to original }
            .groupBy { (_, original) -> obtenerEtiquetaFecha(original.checkIn.toDate()) }
            .map { (etiqueta, lista) ->
                GrupoFechaActividad(
                    etiquetaFecha = etiqueta,
                    actividades = lista.map { it.first }
                )
            }
    }

    private fun obtenerEtiquetaFecha(fecha: Date): String {
        val hoy = Calendar.getInstance()
        val ayer = Calendar.getInstance().apply { add(Calendar.DAY_OF_YEAR, -1) }
        val fechaCal = Calendar.getInstance().apply { time = fecha }

        return when {
            esMismoDia(hoy, fechaCal) -> "Hoy"
            esMismoDia(ayer, fechaCal) -> "Ayer"
            else -> {
                val formato = SimpleDateFormat("d 'de' MMMM", Locale("es", "ES"))
                formato.format(fecha).replaceFirstChar { it.uppercase() }
            }
        }
    }

    private fun esMismoDia(a: Calendar, b: Calendar): Boolean {
        return a.get(Calendar.YEAR) == b.get(Calendar.YEAR) &&
                a.get(Calendar.DAY_OF_YEAR) == b.get(Calendar.DAY_OF_YEAR)
    }
}