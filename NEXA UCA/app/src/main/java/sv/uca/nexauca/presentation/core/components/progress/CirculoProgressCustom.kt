package sv.uca.nexauca.presentation.core.components.progress

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import sv.uca.nexauca.presentation.core.theme.Inter

@Composable
fun CirculoProgressCuston(
    horasCompletadas:Int,
    horasTotal: Int,
    modifier: Modifier = Modifier,
    grosor: Dp = 12.dp,
    colorFondo: Color = Color(0xFF51a2ff).copy(alpha = 0.5f),
    colorprogreso: Color = Color(0xFF372aac)
) {

    val progreso = if (horasTotal > 0) {
        (horasCompletadas.toFloat() / horasTotal.toFloat()).coerceIn(0f, 1f)
    } else 0f


    val progresoAnimado by animateFloatAsState(
        targetValue = progreso,
        animationSpec = tween(durationMillis = 800),
        label = "progreso"
    )

    Box(
        modifier = modifier.size(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke = grosor.toPx()

            drawArc(
                color = colorFondo,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )

            drawArc(
                color = colorprogreso,
                startAngle = -90f,
                sweepAngle = 360f * progresoAnimado,
                useCenter = false,
                style = Stroke(width = stroke, cap = StrokeCap.Round)
            )
        }
        Text(
            text = "${(progresoAnimado * 100).toInt()}%",
            fontSize = 20.sp,
            fontFamily = Inter,
            fontWeight = FontWeight.Medium
        )
    }

}