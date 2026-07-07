package sv.uca.nexauca.presentation.core.components.charts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoGraph
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
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
import sv.uca.nexauca.presentation.core.theme.Inter
import androidx.compose.foundation.layout.size

data class DiaActividad(
    val nombre: String,
    val valor: Float // 0f..1f, altura relativa de la barra
)

object DiaActividadSampleData {
    val items = listOf(
        DiaActividad("Lunes", 0.55f),
        DiaActividad("Martes", 0.85f),
        DiaActividad("Miércoles", 0.35f),
        DiaActividad("Jueves", 0.95f),
        DiaActividad("Viernes", 0.65f),
        DiaActividad("Sábados", 0.15f),
        DiaActividad("Domingo", 0.10f)
    )
}

@Composable
fun TarjetaActividadSemanal(dias: List<DiaActividad>) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFBFB)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "Actividad esta semana",
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Spacer(Modifier.width(6.dp))
                Icon(
                    imageVector = Icons.Filled.AutoGraph,
                    contentDescription = null,
                    tint = Color(0xFF372aac),
                    modifier = Modifier.size(14.dp)
                )
            }

            Spacer(Modifier.height(16.dp))

            GraficaBarrasSemanal(dias = dias)
        }
    }
}

@Composable
fun GraficaBarrasSemanal(dias: List<DiaActividad>) {
    val colorBarra = Color(0xFF3B82F6)

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        dias.forEach { dia ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(32.dp)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height((90 * dia.valor.coerceIn(0.05f, 1f)).dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(colorBarra)
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = dia.nombre.take(3),
                    fontSize = 9.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun TarjetaActividadSemanalPreview() {
    TarjetaActividadSemanal(dias = DiaActividadSampleData.items)
}