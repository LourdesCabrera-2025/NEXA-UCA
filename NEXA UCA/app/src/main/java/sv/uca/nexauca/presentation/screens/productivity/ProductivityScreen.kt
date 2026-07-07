package sv.uca.nexauca.presentation.screens.productivity

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.History
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.components.cards.DashboardActionCard
import sv.uca.nexauca.presentation.core.components.cards.TarjetasProgreso
import sv.uca.nexauca.presentation.core.components.cards.EstadisticaCard
import sv.uca.nexauca.presentation.core.components.cards.EstadisticaCardSampleData
import sv.uca.nexauca.presentation.core.components.cards.TarjetaEstadistica
import sv.uca.nexauca.presentation.core.components.charts.DiaActividad
import sv.uca.nexauca.presentation.core.components.charts.DiaActividadSampleData
import sv.uca.nexauca.presentation.core.components.charts.TarjetaActividadSemanal
import sv.uca.nexauca.presentation.core.components.headers.EncabezadoNexa
import sv.uca.nexauca.presentation.core.components.tables.ActividadRecienteSampleData
import sv.uca.nexauca.presentation.core.components.tables.TableProductivity
import sv.uca.nexauca.presentation.core.components.waves.ModifiedWaveForm
import sv.uca.nexauca.presentation.core.theme.Inter

data class AccesoRapido(
    val icono: ImageVector,
    val colores: List<Color>,
    val titulo: String,
    val descripcion: String,
    val onClick: () -> Unit = {}
)

object AccesoRapidoSampleData {
    val items = listOf(
        AccesoRapido(
            icono = Icons.Filled.CalendarMonth,
            colores = listOf(Color(0xFF372aac), Color(0xFF51a2ff)),
            titulo = "Registrar horas",
            descripcion = "Añade una nueva actividad o registro de horas"
        ),
        AccesoRapido(
            icono = Icons.Filled.History,
            colores = listOf(Color(0xFF16A34A), Color(0xFF4ADE80)),
            titulo = "Historial completo",
            descripcion = "Revisa todas tus actividades registradas"
        )
    )
}

@Composable
fun Productivity(
    horasInternasCompletadas: Int = 50,
    horasInternasTotal: Int = 300,
    horasExternasCompletadas: Int = 178,
    horasExternasTotal: Int = 300,
    estadisticas: List<EstadisticaCard> = EstadisticaCardSampleData.items,
    actividadSemanal: List<DiaActividad> = DiaActividadSampleData.items,
    onBackClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onVerTodasClick: () -> Unit = {}
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6FA))
    ) {
        EncabezadoNexa(onBackClick = onBackClick, onNotificationClick = onNotificationClick)

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item {
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Spacer(Modifier.height(12.dp))

                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Mi Productividad",
                            fontSize = 18.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black
                        )
                        Spacer(Modifier.width(6.dp))
                        Icon(
                            imageVector = Icons.Filled.AutoGraph,
                            contentDescription = null,
                            tint = Color(0xFF372aac),
                            modifier = Modifier.size(16.dp)
                        )
                    }
                    Text(
                        text = "Revisa tu avance y actividades registradas.",
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Normal,
                        color = Color.Gray
                    )

                    Spacer(Modifier.height(16.dp))

                    TarjetasProgreso(
                        horasInternasCompletadas = horasInternasCompletadas,
                        horasInternasTotal = horasInternasTotal,
                        horasExternasCompletadas = horasExternasCompletadas,
                        horasExternasTotal = horasExternasTotal
                    )

                    Spacer(Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        estadisticas.forEach { stat ->
                            TarjetaEstadistica(stat = stat, modifier = Modifier.weight(1f))
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    TarjetaActividadSemanal(dias = actividadSemanal)

                    Spacer(Modifier.height(12.dp))

                    TableProductivity(
                        items = ActividadRecienteSampleData.items,
                        onVerTodasClick = onVerTodasClick
                    )
                }
            }
        }

        ModifiedWaveForm(modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF, heightDp = 900)
@Composable
private fun PantallaProductividadPreview() {
    Productivity()
}