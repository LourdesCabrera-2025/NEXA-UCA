package sv.uca.nexauca.presentation.core.components.waves

import androidx.compose.ui.graphics.Path


fun Path.bottomWavePath(width: Float, height: Float) {
    reset()
    moveTo(0f, height * 0.48f)
    cubicTo(
        width * 0.15f, height * 0.51f,
        width * 0.30f, height * 0.48f,
        width * 0.50f, height * 0.40f
    )
    cubicTo(
        width * 0.65f, height * 0.33f,
        width * 0.80f, height * 0.31f,
        width, height * 0.40f
    )
    lineTo(width, height)
    lineTo(0f, height)
    close()
}