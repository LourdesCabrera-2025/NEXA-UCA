package sv.uca.nexauca.presentation.core.components.cards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.theme.Inter
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row

data class EstadisticaCard(
    val icono: ImageVector,
    val colorIcono: Color,
    val fondoIcono: Color,
    val valor: String,
    val etiqueta: String
)

object EstadisticaCardSampleData {
    val items = listOf(
        EstadisticaCard(
            icono = Icons.Filled.CheckCircle,
            colorIcono = Color(0xFF16A34A),
            fondoIcono = Color(0xFFDCFCE7),
            valor = "12",
            etiqueta = "Aprobadas\nHoras completas"
        ),
        EstadisticaCard(
            icono = Icons.Filled.HourglassBottom,
            colorIcono = Color(0xFFD97706),
            fondoIcono = Color(0xFFFEF3C7),
            valor = "2",
            etiqueta = "Pendientes\nSolicitudes"
        ),
        EstadisticaCard(
            icono = Icons.Filled.CalendarMonth,
            colorIcono = Color(0xFF2563EB),
            fondoIcono = Color(0xFFDBEAFE),
            valor = "8h",
            etiqueta = "Esta semana\nRegistradas"
        )
    )
}

@Composable
fun TarjetaEstadistica(stat: EstadisticaCard, modifier: Modifier = Modifier) {
    val lineasEtiqueta = stat.etiqueta.split("\n")

    Card(
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFBFB)),
        shape = RoundedCornerShape(14.dp)
    ) {
        Column(
            modifier = Modifier.padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(stat.fondoIcono),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = stat.icono,
                    contentDescription = null,
                    tint = stat.colorIcono,
                    modifier = Modifier.size(20.dp)
                )
            }
            Spacer(Modifier.height(8.dp))
            Text(
                text = stat.valor,
                fontSize = 20.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(Modifier.height(2.dp))
            lineasEtiqueta.forEachIndexed { index, linea ->
                Text(
                    text = linea,
                    fontSize = if (index == 0) 11.sp else 10.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun EstadisticasRowPreview() {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        EstadisticaCardSampleData.items.forEach { stat ->
            TarjetaEstadistica(
                stat = stat,
                modifier = Modifier.weight(1f)
            )
        }
    }
}
