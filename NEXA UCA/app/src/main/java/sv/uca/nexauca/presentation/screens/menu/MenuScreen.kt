package sv.uca.nexauca.presentation.screens.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AvTimer
import androidx.compose.material.icons.rounded.BarChart
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import sv.uca.nexauca.presentation.core.components.cards.CardProgress
import sv.uca.nexauca.presentation.core.components.cards.DashboardActionCard
import sv.uca.nexauca.presentation.core.components.waves.BootomWaves
import sv.uca.nexauca.presentation.core.theme.Inter
import sv.uca.nexauca.presentation.core.theme.Space_Grotesk

@Composable

fun MenuScreen(
    viewModel: MenuViewModel = viewModel(),
    onNavigateToProductivity : () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.getDataStudent()
    }

    val student = uiState.student

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = Color(0xFFFAFBFB)
    ) { innerPadding ->

        Box(modifier = Modifier.fillMaxSize()) {

            Column(

                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Filled.Settings,
                        contentDescription = "settings",
                        modifier = Modifier.size(26.dp),
                        tint = Color(0xFF022873)
                    )
                    Text(
                        text = "NEXA UCA",
                        fontSize = 32.sp,
                        fontFamily = Space_Grotesk,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF022873)
                    )
                    Icon(
                        imageVector = Icons.Filled.Notifications,
                        contentDescription = "notification",
                        modifier = Modifier.size(26.dp),
                        tint = Color(0xFF022873)
                    )
                }

                Spacer(modifier = Modifier.height(46.dp))

                student?.let { dataStudentsItem ->
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 16.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(75.dp)
                                .background(
                                    Color.Gray,
                                    shape = CircleShape
                                ),
                            contentAlignment = Alignment.Center
                        ) {
                            AsyncImage(
                                model = dataStudentsItem.user.photoUrl,
                                contentDescription = "perfil",
                                modifier = Modifier
                                    .width(75.dp)
                                    .height(100.dp)
                                    .clip(RoundedCornerShape(16.dp)),
                                contentScale = ContentScale.Crop
                            )
                        }

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "¡Hola ${dataStudentsItem.user.fullName}!",
                                fontSize = 17.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Medium,
                                color = Color.Black
                            )

                            Spacer(modifier = Modifier.height(5.dp))

                            Text(
                                text = "${dataStudentsItem.user.role.name}",
                                fontSize = 14.sp,
                                fontFamily = Inter,
                                fontWeight = FontWeight.Light,
                                color = Color(0xFF056CF2)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        CardProgress()

                        Spacer(modifier = Modifier.height(10.dp))

                        DashboardActionCard(
                            onClick = {
                                onNavigateToProductivity()
                            },
                            Icono = {
                                Icon(
                                    Icons.Rounded.BarChart,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                            colorIcono = listOf(Color(0xFF0069a8), Color(0xFF0084d1)),
                            titulo = "Mi Productividad",
                            description = "Consulte sus estaadisticas, avance y reportes"
                        )
                        Spacer(modifier = Modifier.height(10.dp))

                        DashboardActionCard(
                            Icono = {
                                Icon(
                                    Icons.Rounded.AvTimer,
                                    contentDescription = null,
                                    tint = Color.White
                                )
                            },
                            colorIcono = listOf(Color(0xFF008236), Color(0xFF00a63e)),
                            titulo = "Registrar horas sociales",
                            description = "Inicia tu jornada de horas sociales en tiempo real"
                        )

                    }

                }
            }

            BootomWaves(modifier = Modifier.align(Alignment.BottomCenter))

        }


    }

}
