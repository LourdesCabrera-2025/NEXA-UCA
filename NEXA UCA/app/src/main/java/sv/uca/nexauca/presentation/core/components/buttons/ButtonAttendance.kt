package sv.uca.nexauca.presentation.core.components.buttons


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import sv.uca.nexauca.presentation.core.theme.Inter

@Composable
fun AttendanceButton(

    running: Boolean,

    onFinish: () -> Unit

) {

    Button(

        onClick = onFinish,

        modifier = Modifier
            .fillMaxWidth()
            .height(58.dp),

        shape = RoundedCornerShape(18.dp),

        colors = ButtonDefaults.buttonColors(

            containerColor = Color(0xFF022873)

        )

    ) {

        Text(

            text =
                if (running)
                    "Finalizar Jornada"
                else
                    "Jornada Finalizada",

            style = MaterialTheme.typography.titleMedium,

            fontFamily = Inter,

            fontWeight = FontWeight.Bold,

            color = Color.White

        )

    }

}