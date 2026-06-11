package sv.uca.nexauca.presentation.core.components.alerts


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.dokar.sonner.ToastType
import com.dokar.sonner.ToastWidthPolicy
import com.dokar.sonner.Toaster
import com.dokar.sonner.ToasterState


@Composable
fun ToastAlerts(state : ToasterState) {

    Toaster(
        state = state,
        contentColor = { toast ->
            when (toast.type) {
                ToastType.Success -> Color(0xFF155724)
                ToastType.Error -> Color(0xFF721C24)
                ToastType.Warning -> Color(0xFF856404)
                ToastType.Info -> Color(0xFF0C5460)

                else -> Color(0xFF0B1F4D)
            }
        },
        border = { toast ->
            BorderStroke(
                width = 1.dp,
                color = when (toast.type) {
                    ToastType.Success -> Color(0xFFC3E6CB)
                    ToastType.Error -> Color(0xFFF5C6CB)
                    ToastType.Warning -> Color(0xFFFFEEBA)
                    ToastType.Info -> Color(0xFFBEE5EB)
                    else -> Color(0xFFDDE6FF)
                }
            )
        },
        background = { toast ->
            when (toast.type) {
                ToastType.Success -> Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFD4EDDA),
                        Color.White
                    )
                )

                ToastType.Error -> Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFF8D7DA),
                        Color.White
                    )
                )

                ToastType.Warning -> Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFFFF3CD),
                        Color.White
                    )
                )

                ToastType.Info -> Brush.linearGradient(
                    colors = listOf(
                        Color(0xFFD1ECF1),
                        Color.White
                    )
                )

                else -> Brush.linearGradient(colors = listOf(Color.White, Color(0xFFF4F7FF)))
            }
        },
        shape = { RoundedCornerShape(18.dp) },
        elevation = 8.dp,
        shadowAmbientColor = Color.Black.copy(alpha = 0.14f),
        shadowSpotColor = Color.Black.copy(alpha = 0.10f),
        contentPadding = {
            PaddingValues(
                horizontal = 16.dp,
                vertical = 14.dp
            )
        },
        containerPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp),
        widthPolicy = { ToastWidthPolicy()},
        offset = IntOffset(0, 24)
    )
}