package sv.uca.nexauca.presentation.core.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.components.progress.CirculoProgressCuston
import sv.uca.nexauca.presentation.core.theme.Inter


@Composable
fun TarjetasProgreso(
    horasInternasCompletadas: Int,
    horasInternasTotal: Int,
    horasExternasCompletadas: Int,
    horasExternasTotal: Int
) {
    Column {
        CardProgress(
            titulo = "Horas Internas",
            horasCompletadas = horasInternasCompletadas,
            horasTotal = horasInternasTotal
        )

        Spacer(Modifier.height(12.dp))

        CardProgress(
            titulo = "Horas Externas",
            horasCompletadas = horasExternasCompletadas,
            horasTotal = horasExternasTotal
        )
    }
}

@Composable
fun CardProgress(
    titulo: String = "Tu Progreso",
    horasCompletadas: Int = 72,
    horasTotal: Int = 600
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFAFBFB)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            CirculoProgressCuston(
                horasCompletadas = horasCompletadas,
                horasTotal = horasTotal,
                modifier = Modifier.width(64.dp).height(64.dp),
                grosor = 10.dp
            )

            Spacer(Modifier.width(16.dp))

            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = titulo,
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Spacer(Modifier.height(4.dp))

                Text(
                    text = "${horasCompletadas}/${horasTotal} horas completadas",
                    fontSize = 11.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray
                )
                Spacer(Modifier.height(8.dp))

                BarraProgresoLineal(
                    progreso = if (horasTotal > 0)
                        (horasCompletadas.toFloat() / horasTotal.toFloat()).coerceIn(0f, 1f)
                    else 0f
                )
            }
        }
    }
}

@Composable
private fun BarraProgresoLineal(progreso: Float) {
    val progresoSeguro = progreso.coerceIn(0f, 1f)
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(6.dp)
            .clip(RoundedCornerShape(50))
            .background(Color(0xFF51a2ff).copy(alpha = 0.5f))
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(progresoSeguro)
                .height(6.dp)
                .clip(RoundedCornerShape(50))
                .background(Color(0xFF372aac))
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F6FA)
@Composable
private fun CardProgressPreview() {
    CardProgress(
        titulo = "Tu progreso",
        horasCompletadas = 225,
        horasTotal = 300
    )
}

@Preview(showBackground = true, backgroundColor = 0xFFF5F6FA)
@Composable
private fun TarjetasProgresoPreview() {
    TarjetasProgreso(
        horasInternasCompletadas = 50,
        horasInternasTotal = 300,
        horasExternasCompletadas = 178,
        horasExternasTotal = 300
    )
}