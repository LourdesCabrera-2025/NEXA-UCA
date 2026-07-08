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
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import sv.uca.nexauca.presentation.core.components.cards.TarjetasProgreso
import sv.uca.nexauca.presentation.core.components.cards.TarjetaEstadistica
import sv.uca.nexauca.presentation.core.components.charts.TarjetaActividadSemanal
import sv.uca.nexauca.presentation.core.components.headers.HeaderNexa
import sv.uca.nexauca.presentation.core.components.tables.TableProductivity
import sv.uca.nexauca.presentation.core.components.waves.ModifiedWaveForm
import sv.uca.nexauca.presentation.core.theme.Inter
import sv.uca.nexauca.data.mappers.toDiasActividad
import sv.uca.nexauca.data.mappers.toEstadisticaCards
import sv.uca.nexauca.data.mappers.toActividadReciente

@Composable
fun Productivity(
    viewModel: ProductividadViewModel = viewModel(),
    onBackClick: () -> Unit = {},
    onNotificationClick: () -> Unit = {},
    onVerTodasClick: () -> Unit = {}
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F6FA))
    ) {
        HeaderNexa(onBackClick = onBackClick, onNotificationClick = onNotificationClick)

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

                    if (uiState.errorMessage != null) {
                        Text(
                            text = uiState.errorMessage ?: "",
                            color = Color.Red,
                            fontSize = 12.sp,
                            fontFamily = Inter
                        )
                        Spacer(Modifier.height(12.dp))
                    }

                    TarjetasProgreso(
                        horasInternasCompletadas = uiState.horasInternas.toInt(),
                        horasInternasTotal = uiState.metaHoras,
                        horasExternasCompletadas = uiState.horasExternas.toInt(),
                        horasExternasTotal = uiState.metaHoras
                    )

                    Spacer(Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        uiState.toEstadisticaCards().forEach { stat ->
                            TarjetaEstadistica(
                                stat = stat,
                                modifier = Modifier.weight(1f)
                                    .height(100.dp)
                            )
                        }
                    }

                    Spacer(Modifier.height(12.dp))

                    TarjetaActividadSemanal(dias = uiState.toDiasActividad())

                    Spacer(Modifier.height(12.dp))

                    TableProductivity(
                        items = uiState.actividadReciente.toActividadReciente(),
                        onVerTodasClick = onVerTodasClick
                    )
                }
            }
        }

        ModifiedWaveForm(modifier = Modifier.fillMaxWidth())
    }
}