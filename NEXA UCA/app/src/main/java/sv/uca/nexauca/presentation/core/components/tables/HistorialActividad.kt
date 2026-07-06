package sv.uca.nexauca.presentation.core.components.tables

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Spacer
import androidx.compose.material3.HorizontalDivider
import androidx.compose.ui.graphics.Color
import sv.uca.nexauca.presentation.core.theme.Inter
import androidx.compose.foundation.layout.height



data class GrupoFechaActividad(
    val etiquetaFecha: String,
    val actividades: List<ActividadReciente>
)
//datos de ejemplopara Preview


@Preview(showBackground = true)
@Composable
fun HistorialActividadPreview() {
    Column(modifier = Modifier.padding(16.dp)) {
        HistorialActividadSampleData.grupos.forEach { grupo ->
            Text(
                text = grupo.etiquetaFecha,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            grupo.actividades.forEachIndexed { index, actividad ->
                FilaActividad(item = actividad)
                if (index != grupo.actividades.lastIndex) {
                    HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

object HistorialActividadSampleData {
    val grupos = listOf(
        GrupoFechaActividad(
            etiquetaFecha = "Hoy",
            actividades = ActividadRecienteSampleData.items
        ),
        GrupoFechaActividad(
            etiquetaFecha = "Ayer",
            actividades = listOf(
                ActividadRecienteSampleData.items[0].copy(
                    fechaHora = "14 abril 2026 - 02:30:45",
                    duracion = "2h 30m"
                )
            )
        ),
        GrupoFechaActividad(
            etiquetaFecha = "7 de Febrero",
            actividades = listOf(
                ActividadRecienteSampleData.items[1].copy(
                    fechaHora = "7 febrero 2026 - 01:15:00",
                    duracion = "1h 15m"
                )
            )
        )
    )
}