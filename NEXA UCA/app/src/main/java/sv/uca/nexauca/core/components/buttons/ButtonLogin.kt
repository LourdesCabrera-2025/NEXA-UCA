package sv.uca.nexauca.core.components.buttons


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import sv.uca.nexauca.R


@Composable
fun LoginButton(onClick : () -> Unit) {


        Button(
            onClick = {   },
            modifier = Modifier
                .fillMaxWidth(0.87f),
            shape = RoundedCornerShape(5.dp,15.dp,5.dp,15.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF022873)
            ),
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 10.dp
            )
        ) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {

                Text(
                    text = "Inicia sesión con microsoft",
                    color = Color.White,
                )

                Icon(
                    painter = painterResource(R.drawable.ic_icon_microsoft),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp).align(Alignment.CenterEnd),
                    tint = Color.Unspecified
                )
            }
        }
    }

