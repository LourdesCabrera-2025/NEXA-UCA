package sv.uca.nexauca.presentation.core.components.filters

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

enum class EstadoActividad(val label: String) {
    TODAS("Todas"),
    APROBADAS("Aprobadas"),
    PENDIENTES("Pendientes"),
    RECHAZADAS("Rechazadas")
}


@Composable
fun FilterTabsRow(
    estadoSeleccionado: EstadoActividad,
    onEstadoSelected: (EstadoActividad) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .horizontalScroll(rememberScrollState())
            .padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        EstadoActividad.values().forEach { estado ->
            val seleccionado = estado == estadoSeleccionado
            Text(
                text = estado.label,
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = if (seleccionado) FontWeight.SemiBold else FontWeight.Normal,
                    color = if (seleccionado) Color.White else Color(0xFF64748B)
                ),
                modifier = Modifier
                    .clickable { onEstadoSelected(estado) }
                    .background(
                        color = if (seleccionado) Color(0xFF3B5BFD) else Color(0xFFF1F5F9),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
        }
    }
}