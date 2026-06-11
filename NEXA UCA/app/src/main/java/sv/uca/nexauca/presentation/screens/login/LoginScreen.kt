package sv.uca.nexauca.presentation.screens.login

import android.util.Log
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dokar.sonner.ToasterState
import com.dokar.sonner.rememberToasterState
import sv.uca.nexauca.R
import sv.uca.nexauca.presentation.core.components.alerts.ToastAlerts
import sv.uca.nexauca.presentation.core.components.buttons.LoginButton
import sv.uca.nexauca.presentation.core.events.UIEvent
import sv.uca.nexauca.presentation.core.notifier.showNexaToast
import sv.uca.nexauca.presentation.core.theme.Inter
import sv.uca.nexauca.presentation.core.theme.Space_Grotesk


@Composable
fun LoginScreen(
    onNavigateHome: () -> Unit,
    viewModel: LoginViewModel = viewModel()
){

    val toasterState = rememberToasterState ()

    val activity = LocalActivity.current

    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when(event) {
                is UIEvent.ShowToast -> {
                    showNexaToast(
                        toast = event.toastSonner,
                        toasterState = toasterState
                    )
                }

                is UIEvent.NavigateToHome -> {
                    onNavigateHome()
                }
                else -> Unit
            }
        }
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0),
        containerColor = Color(0xFFFAFBFB)
    ) {innerPadding->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFAFBFB))
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(420.dp)
                    .align(Alignment.TopCenter)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(400.dp)
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 32.dp,
                                bottomEnd = 32.dp
                            )
                        )
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF0038D9),
                                    Color(0xFF001B43)
                                )
                            )
                        )
                ){
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(95.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        val path = Path().apply {
                            moveTo(0f,50f)
                            cubicTo(
                                size.width * 0.18f,-10f,
                                size.width * 0.65f, 120f,
                                size.width, 30f
                            )

                            lineTo(size.width, size.height)
                            lineTo(0f, size.height)
                            close()
                        }

                        drawPath(
                            path = path,
                            color = Color(0xFF79AFFF),
                            alpha = 0.65f
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(80.dp)
                            .align(Alignment.BottomCenter)
                    ) {
                        val path = Path().apply {
                            moveTo(0f,55f)
                            cubicTo(
                                size.width * 0.18f,0f,
                                size.width *0.70f, 115f,
                                size.width, 35f
                            )
                            lineTo(size.width, size.height)
                            lineTo(0f, size.height)
                            close()
                        }
                        drawPath(
                            path = path,
                            color = Color(0xFFFAFBFB)
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .align(Alignment.BottomCenter)
                        .shadow(
                            elevation = 32.dp,
                            shape = CircleShape,
                            ambientColor = Color.Black,
                            spotColor = Color.Black
                        )
                        .clip(CircleShape)
                        .background(Color(0xFF03258C)),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.main_icon),
                        contentDescription = null,
                        modifier = Modifier.size(115.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopCenter)
                    .padding(top = 470.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Sistema de gestión de horas sociales",
                    fontSize = 20.sp,
                    fontFamily = Space_Grotesk,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF000000)
                )

                Spacer(modifier = Modifier.height(14.dp))

                Text(
                    text = "Control y seguimiento académico en tiempo real",
                    fontSize = 14.sp,
                    fontFamily = Inter,
                    fontWeight = FontWeight.Normal,
                    color = Color(0xFF8C8C8C)
                )

                Spacer(modifier = Modifier.height(200.dp))

                LoginButton(
                    onClick = {
                        Log.d("AUTH_MICROSOFT", "Boton presionado")
                        activity?.let {
                            viewModel.loginWithMicrosoft(it)
                        }
                    }
                )

            }
            ToastAlerts(state = toasterState)
        }
    }
}