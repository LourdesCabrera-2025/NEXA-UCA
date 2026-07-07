package sv.uca.nexauca.presentation.core.components.waves

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


/**cree otro archivo de wave para no modificar el original, porque la pantalla 3 y 4 lo ocupan pero
 * distinto a como lo vamos a ocupar en la pantalla 8 y 9
**/
@Composable
fun ModifiedWaveForm(
    modifier: Modifier = Modifier,
    height: Dp = 80.dp,
    showLocationStatus: Boolean = true
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(height)
    ) {
        Canvas(Modifier.fillMaxSize()) {
            val width = size.width
            val canvasHeight = size.height

            val top = Path().apply {
                topWavePath(width, canvasHeight)
            }

            val bottom = Path().apply {
                bottomWavePath(width, canvasHeight)
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

        if (showLocationStatus) {
            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Spacer(modifier = Modifier.width(8.dp))

            }
        }
    }
}