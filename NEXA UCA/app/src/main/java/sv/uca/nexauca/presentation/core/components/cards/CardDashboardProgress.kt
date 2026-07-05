package sv.uca.nexauca.presentation.core.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.trace
import sv.uca.nexauca.presentation.core.components.progress.CirculoProgressCuston
import sv.uca.nexauca.presentation.core.theme.Inter

@Composable
fun CardProgress(
    horasCompletadas: Int = 72,
    horasTotal: Int = 600
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFFAFBFB)
        ),
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row{
                    CirculoProgressCuston(
                        horasCompletadas = horasCompletadas,
                        horasTotal = horasTotal,
                        modifier = Modifier.width(64.dp).height(64.dp),
                        grosor = 6.dp
                    )

                    Spacer(Modifier.width(16.dp))

                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Tu Progreso",
                            fontSize = 14.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Medium,
                            color = Color.Black
                        )
                        Spacer(Modifier.height(8.dp))

                        Text(
                            text = "${horasCompletadas}/${horasTotal} horas completadas",
                            fontSize = 11.sp,
                            fontFamily = Inter,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray
                        )
                        Spacer(Modifier.height(8.dp))

                        LinearProgressIndicator(
                            progress = {
                                if(horasTotal > 0)
                                    (horasCompletadas.toFloat() / horasTotal.toFloat()).coerceIn(0f,1f)
                                else 0f
                            },

                            modifier = Modifier
                                .fillMaxWidth()
                                .height(6.dp)
                                .clip(RoundedCornerShape(3.dp)),
                            trackColor = Color(0xFF51a2ff).copy(alpha = 0.5f),
                            color =  Color(0xFF372aac)
                        )
                    }
                }
            }
        }
    }
}