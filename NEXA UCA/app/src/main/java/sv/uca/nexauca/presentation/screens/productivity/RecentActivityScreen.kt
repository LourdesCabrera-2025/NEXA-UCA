package sv.uca.nexauca.presentation.screens.productivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sv.uca.nexauca.presentation.core.components.cards.EstadisticaCard
import sv.uca.nexauca.presentation.core.components.cards.TarjetaEstadistica
import sv.uca.nexauca.presentation.core.components.filters.EstadoActividad
import sv.uca.nexauca.presentation.core.components.filters.FilterTabsRow
import sv.uca.nexauca.presentation.core.components.filters.FiltersBottomSheet
import sv.uca.nexauca.presentation.core.components.filters.OrdenActividad
import sv.uca.nexauca.presentation.core.components.headers.HeaderNexa
import sv.uca.nexauca.presentation.core.components.inputs.BuscadorFiltroBar
import sv.uca.nexauca.presentation.core.components.tables.FilaActividad
import sv.uca.nexauca.presentation.core.components.tables.GrupoFechaActividad
import sv.uca.nexauca.presentation.core.components.waves.ModifiedWaveForm

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistorialActividadesScreen(
    estadisticas: List<EstadisticaCard>,
    grupos: List<GrupoFechaActividad>,
    query: String,
    onQueryChange: (String) -> Unit,
    estadoSeleccionado: EstadoActividad,
    onEstadoSelected: (EstadoActividad) -> Unit,
    ordenSeleccionado: OrdenActividad,
    onOrdenSelected: (OrdenActividad) -> Unit,
    onLimpiarFiltros: () -> Unit = {},
    onBackClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {}
) {
    var mostrarFiltrosSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            HeaderNexa(
                onBackClick = onBackClick,
                onNotificationClick = onNotificationClick
            )

            Text(
                text = "Actividad Reciente",
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF1E293B)
                ),
                modifier = Modifier.padding(top = 8.dp)
            )
            Text(
                text = "Visualiza y filtra tus actividades registradas",
                style = MaterialTheme.typography.bodyMedium,
                color = Color(0xFF64748B)
            )

            BuscadorFiltroBar(
                query = query,
                onQueryChange = onQueryChange,
                onFiltrosClick = { mostrarFiltrosSheet = true },
                modifier = Modifier.padding(top = 2.dp)
            )

            FilterTabsRow(
                estadoSeleccionado = estadoSeleccionado,
                onEstadoSelected = onEstadoSelected,
                modifier = Modifier.padding(top = 12.dp)
            )
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp)
                .padding(top = 10.dp)
        ) {
            item {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    modifier = Modifier.padding(bottom = 12.dp)
                ) {
                    estadisticas.forEach { stat ->
                        TarjetaEstadistica(
                            stat = stat,
                            modifier = Modifier.weight(1f)
                        )
                    }
                }
            }

            grupos.forEach { grupo ->
                item {
                    Text(
                        text = grupo.etiquetaFecha,
                        style = MaterialTheme.typography.titleSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(grupo.actividades) { actividad ->
                    FilaActividad(item = actividad)
                    if (actividad != grupo.actividades.last()) {
                        HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                    }
                }
            }
        }

        ModifiedWaveForm(modifier = Modifier.fillMaxWidth())
    }

    if (mostrarFiltrosSheet) {
        FiltersBottomSheet(
            sheetState = sheetState,
            ordenSeleccionado = ordenSeleccionado,
            onOrdenSelected = onOrdenSelected,
            onDismiss = { mostrarFiltrosSheet = false },
            onLimpiar = {
                onLimpiarFiltros()
                mostrarFiltrosSheet = false
            },
            onAplicar = { mostrarFiltrosSheet = false }
        )

    }
}