package sv.uca.nexauca.presentation.core.components.tables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.theme.Inter


@Composable
fun SeccionFechaActividad(
    grupo: GrupoFechaActividad,
    onItemClick: (ActividadReciente) -> Unit = {}
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = grupo.etiquetaFecha,
            fontSize = 14.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFAFBFB)),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                grupo.actividades.forEachIndexed { index, item ->
                    FilaActividad(item = item, onClick = { onItemClick(item) })
                    if (index != grupo.actividades.lastIndex) {
                        HorizontalDivider(color = Color(0xFFF0F0F0), thickness = 1.dp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
private fun SeccionFechaActividadPreview() {
    SeccionFechaActividad(grupo = HistorialActividadSampleData.grupos.first())
}