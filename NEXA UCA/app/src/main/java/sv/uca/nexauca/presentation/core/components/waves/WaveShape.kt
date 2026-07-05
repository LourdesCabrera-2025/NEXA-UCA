package sv.uca.nexauca.presentation.core.components.waves

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.LocationOff
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.theme.Inter

@Composable
fun BootomWaves (
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(300.dp)
    ){
        Canvas(Modifier.fillMaxSize()) {
            val width = size.width
            val height = size.height

            val top = Path().apply {
                topWavePath(width, height)
            }

            val bottom = Path().apply {
                bottomWavePath(width, height)
            }

            drawPath(
                path = top,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF03258C).copy(alpha = 0.4f),
                        Color(0xFF022873).copy(alpha = 0.4f)
                    )
                )
            )

            drawPath(
                path = bottom,
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF03258C),
                        Color(0xFF022873)
                    )
                )
            )
        }

        Row(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Rounded.LocationOff,
                contentDescription = null,
                tint = Color.White,
                modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Ubicación no activa",
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = Inter,
                fontWeight = FontWeight.Medium
            )
        }
    }
}