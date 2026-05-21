package sv.uca.nexauca.core.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.pdm0126.nexauca.R

val Inter = FontFamily(

    Font(
        resId = R.font.inter_18pt_regular,
        weight = FontWeight.Normal
    ),

    Font(
        resId = R.font.inter_18pt_light,
        weight = FontWeight.Light
    ),

    Font(
        resId = R.font.inter_18pt_medium,
        weight = FontWeight.Medium
    )
)

val Space_Grotesk = FontFamily(

    Font(
        resId = R.font.spacegrotesk_bold,
        weight = FontWeight.Bold
    )
)