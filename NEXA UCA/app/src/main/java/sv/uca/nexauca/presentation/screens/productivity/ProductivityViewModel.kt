package sv.uca.nexauca.presentation.screens.productivity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.Timestamp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.repositories.api.ProductividadApiRepository
import sv.uca.nexauca.data.services.auth.AuthService
import sv.uca.nexauca.presentation.core.state.ResultState
import java.util.Calendar
import sv.uca.nexauca.data.models.ActividadRecienteItem
import sv.uca.nexauca.data.repositories.impl.ProductividadRepositoryImpl

data class ProductividadUiState(
    val isLoading: Boolean = true,
    val horasInternas: Double = 0.0,
    val horasExternas: Double = 0.0,
    val metaHoras: Int = 300,
    val aprobadas: Int = 0,
    val pendientes: Int = 0,
    val horasEstaSemana: Double = 0.0,
    val actividadPorDia: List<Double> = List(7) { 0.0 },
    val actividadReciente: List<ActividadRecienteItem> = emptyList(),
    val errorMessage: String? = null
)

class ProductividadViewModel : ViewModel() {

    private val repository: ProductividadApiRepository = ProductividadRepositoryImpl()
    private val authService = AuthService()

    private val _uiState = MutableStateFlow(ProductividadUiState())
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

            val (inicioSemana, finSemana) = obtenerRangoSemanaActual()

            val horasResult = repository.getHorasPorTipo(uid)
            val actividadesResult = repository.getActividadesUsuario(uid)
            val asistenciasResult = repository.getAsistenciasSemana(uid, inicioSemana, finSemana)
            val recienteResult = repository.getActividadReciente(uid, limite = 5)

            var horasInternas = 0.0
            var horasExternas = 0.0
            when (horasResult) {
                is ResultState.Success -> {
                    horasResult.data.forEach { (tipo, horas) ->
                        when {
                            tipo.contains("interno", ignoreCase = true) -> horasInternas += horas
                            tipo.contains("externo", ignoreCase = true) -> horasExternas += horas
                        }
                    }
                }
                is ResultState.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = horasResult.message
                    )
                    return@launch
                }
                is ResultState.Loading -> Unit
            }

            var aprobadas = 0
            var pendientes = 0
            when (actividadesResult) {
                is ResultState.Success -> {
                    aprobadas = actividadesResult.data.count { it }
                    pendientes = actividadesResult.data.count { !it }
                }
                is ResultState.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = actividadesResult.message
                    )
                    return@launch
                }
                is ResultState.Loading -> Unit
            }

            var horasEstaSemana = 0.0
            val actividadPorDia = MutableList(7) { 0.0 }
            when (asistenciasResult) {
                is ResultState.Success -> {
                    asistenciasResult.data.forEach { (checkIn, checkOut) ->
                        if (checkOut != null) {
                            val duracionHoras = (checkOut.seconds - checkIn.seconds) / 3600.0
                            horasEstaSemana += duracionHoras

                            val calendar = Calendar.getInstance().apply {
                                time = checkIn.toDate()
                            }
                            // Calendar.DAY_OF_WEEK: domingo=1 ... sábado=7
                            // Convertimos a índice 0=lunes ... 6=domingo
                            val diaSemana = (calendar.get(Calendar.DAY_OF_WEEK) + 5) % 7
                            actividadPorDia[diaSemana] += duracionHoras
                        }
                    }
                }
                is ResultState.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = asistenciasResult.message
                    )
                    return@launch
                }
                is ResultState.Loading -> Unit
            }

            val actividadReciente = when (recienteResult) {
                is ResultState.Success -> recienteResult.data
                is ResultState.Error -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false,
                        errorMessage = recienteResult.message
                    )
                    return@launch
                }
                is ResultState.Loading -> emptyList()
            }

            _uiState.value = _uiState.value.copy(
                isLoading = false,
                horasInternas = horasInternas,
                horasExternas = horasExternas,
                aprobadas = aprobadas,
                pendientes = pendientes,
                horasEstaSemana = horasEstaSemana,
                actividadPorDia = actividadPorDia,
                actividadReciente = actividadReciente
            )
        }
    }

    private fun obtenerRangoSemanaActual(): Pair<Timestamp, Timestamp> {
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        val inicio = Timestamp(calendar.time)

        calendar.add(Calendar.DAY_OF_WEEK, 6)
        calendar.set(Calendar.HOUR_OF_DAY, 23)
        calendar.set(Calendar.MINUTE, 59)
        calendar.set(Calendar.SECOND, 59)
        val fin = Timestamp(calendar.time)

        return inicio to fin
    }
}