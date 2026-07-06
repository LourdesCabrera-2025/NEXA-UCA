package sv.uca.nexauca.presentation.core.components.tables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.Groups
import androidx.compose.material.icons.filled.MenuBook
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.theme.Inter



enum class EstadoActividad(val etiqueta: String, val color: Color, val fondo: Color) {
    APROBADO("Aprobado", Color(0xFF16A34A), Color(0xFFDCFCE7)),
    PENDIENTE("Pendiente", Color(0xFFD97706), Color(0xFFFEF3C7))
}


data class ActividadReciente(
    val icono: ImageVector,
    val colorIcono: Color,
    val fondoIcono: Color,
    val titulo: String,
    val fechaHora: String,
    val estado: EstadoActividad,
    val duracion: String
)

//Datos de ejemplo

object ActividadRecienteSampleData {
    val items = listOf(
        ActividadReciente(
            icono = Icons.Filled.MenuBook,
            colorIcono = Color(0xFF16A34A),
            fondoIcono = Color(0xFFDCFCE7),
            titulo = "Biblioteca de Teología",
            fechaHora = "9 mayo 2026 - 02:14:36",
            estado = EstadoActividad.APROBADO,
            duracion = "2h 14m"
        ),
        ActividadReciente(
            icono = Icons.Filled.Groups,
            colorIcono = Color(0xFFD97706),
            fondoIcono = Color(0xFFFEF3C7),
            titulo = "Tutorías académicas",
            fechaHora = "8 mayo 2026 - 01:30:00",
            estado = EstadoActividad.PENDIENTE,
            duracion = "1h 30m"
        ),
        ActividadReciente(
            icono = Icons.Filled.CalendarMonth,
            colorIcono = Color(0xFF2563EB),
            fondoIcono = Color(0xFFDBEAFE),
            titulo = "Apoyo en eventos",
            fechaHora = "6 mayo 2026 - 03:00:00",
            estado = EstadoActividad.APROBADO,
            duracion = "3h 00m"
        )
    )
}


@Composable
fun TableProductivity(
    items: List<ActividadReciente>,
    onVerTodasClick: () -> Unit = {},
    onItemClick: (ActividadReciente) -> Unit = {}
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFBFB)),
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Actividad Reciente",
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = Color.Black
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.clickable(onClick = onVerTodasClick)
                ) {
                    Text(
                        text = "Ver todas",
                        fontSize = 12.sp,
                        fontFamily = Inter,
                        fontWeight = FontWeight.Medium,
                        color = Color(0xFF372aac)
                    )
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
                        contentDescription = null,
                        tint = Color(0xFF372aac),
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            items.forEachIndexed { index, item ->
                FilaActividad(item = item, onClick = { onItemClick(item) })
                if (index != items.lastIndex) {
                    HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
fun FilaActividad(
    item: ActividadReciente,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(vertical = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(item.fondoIcono),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = item.icono,
                contentDescription = null,
                tint = item.colorIcono,
                modifier = Modifier.size(18.dp)
            )
        }

        Spacer(Modifier.width(10.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = item.titulo,
                fontSize = 13.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium,
                color = Color.Black
            )
            Spacer(Modifier.height(2.dp))
            Text(
                text = item.fechaHora,
                fontSize = 11.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Light,
                color = Color.Gray
            )
        }

        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(item.estado.fondo)
                    .padding(horizontal = 8.dp, vertical = 3.dp)
            ) {
                Text(
                    text = item.estado.etiqueta,
                    fontSize = 10.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Medium,
                    color = item.estado.color
                )
            }
            Spacer(Modifier.width(8.dp))
            Text(
                text = item.duracion,
                fontSize = 11.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Light,
                color = Color.Gray
            )
        }

        Spacer(Modifier.width(4.dp))

        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = Color.Gray,
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun TableProductivityPreview() {
    TableProductivity(items = ActividadRecienteSampleData.items)
}