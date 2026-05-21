package sv.uca.nexauca.features.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sv.uca.nexauca.core.theme.Inter
import sv.uca.nexauca.core.theme.Space_Grotesk


@Composable
fun SplashScreen(
    onSplashFinished: () -> Unit,
    splashScreenViewModel: SplashScreenViewModel = viewModel()
) {
    /***
     * ANIMACIONES A UTILIZAR
     */
    val titleAlpha = remember { Animatable(0f) }
    val titleOffset = remember { Animatable(12f) }
    val lineWidth = remember { Animatable(0f) }
    val contentAlpha = remember { Animatable(0f) }
//    val progress = remember { Animatable(0f) }
    val shapeRotation = remember { Animatable(0f) }
    val shapeCorner = remember { Animatable(10f) }
    val shapeScale = remember { Animatable(1f) }
    val shapeAlpha = remember { Animatable(1f) }

    val loadingMessage = splashScreenViewModel.loadingMessage
    val progress = splashScreenViewModel.progress
    val isFinished = splashScreenViewModel.isFinished

    val primaryBlue = Color(0xFF0038D9)
    val darkBlue = Color(0xFF001B43)
    val softGray = Color(0xFF8A8A8A)

    val animateProgress by animateFloatAsState(
        targetValue = progress,
        animationSpec = tween(
            durationMillis = 2000,
            easing = FastOutSlowInEasing
        ),
        label = "ProgressAnimation"
    )

    var dots by remember {
        mutableStateOf("")
    }

    LaunchedEffect(Unit) {

        shapeRotation.animateTo(
            targetValue = 45f,

            animationSpec = tween(
                durationMillis = 500,
            )
        )

        shapeCorner.animateTo(
            targetValue = 100f,

            animationSpec = tween(
                durationMillis = 400,
            )
        )

        shapeScale.animateTo(
            targetValue = 1.3f,

            animationSpec = tween(
                durationMillis = 450,
                easing = FastOutSlowInEasing
            )
        )

        delay(200)

        shapeAlpha.animateTo(
            targetValue = 0f,

            animationSpec = tween(300)
        )
        launch {
            titleAlpha.animateTo(
                targetValue = 1f,

                animationSpec = tween(
                    durationMillis = 850,
                    easing = LinearOutSlowInEasing
                )
            )
        }

        launch {
            titleOffset.animateTo(
                targetValue = 0f,

                animationSpec = tween(
                    durationMillis = 850,
                    easing = LinearOutSlowInEasing
                )
            )
        }

        delay(450)

        lineWidth.animateTo(
            targetValue = 170f,

            animationSpec = tween(
                durationMillis = 700,
                easing = FastOutSlowInEasing
            )
        )

        contentAlpha.animateTo(
            targetValue = 1f,

            animationSpec = tween(
                durationMillis = 500
            )
        )

        splashScreenViewModel.startLoading()

        launch {
            while (true) {
                dots ="."
                delay(250)

                dots =".."
                delay(350)

                dots ="..."
                delay(450)

                dots =""
                delay(550)
            }
        }

        delay(800)

    }

    LaunchedEffect(isFinished) {
        if (isFinished) {
            onSplashFinished()
        }
    }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 36.dp),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .size(56.dp)
                .graphicsLayer {
                    rotationZ = shapeRotation.value
                    scaleX = shapeScale.value
                    scaleY = shapeScale.value
                    alpha = shapeAlpha.value
                }
                .background(
                    color = primaryBlue,
                    shape = RoundedCornerShape(shapeCorner.value.dp)
                )
        )
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "NEXA UCA",

                color = darkBlue,

                fontSize = 36.sp,

                fontFamily = Space_Grotesk,

                fontWeight = FontWeight.Bold,

                modifier = Modifier
                    .alpha(titleAlpha.value)
                    .offset(y = titleOffset.value.dp)
            )

            Spacer(modifier = Modifier.height(14.dp))

            Box(
                modifier = Modifier
                    .width(lineWidth.value.dp)
                    .height(5.dp)
                    .background(
                        color = primaryBlue,
                        shape = RoundedCornerShape(50.dp)
                    )
            )

        }

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "$loadingMessage$dots",

            color = softGray,

            fontSize = 13.sp,

            fontFamily = Inter,

            fontWeight = FontWeight.Medium,

            modifier = Modifier
                .alpha(contentAlpha.value)
                .align(Alignment.BottomCenter)
                .padding(bottom = 80.dp)
        )

        LinearProgressIndicator(
            progress = { animateProgress },

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 70.dp)
                .fillMaxWidth(0.75f)
                .height(6.dp)
                .alpha(contentAlpha.value),
            color = primaryBlue,
            trackColor = Color(0xFFE3E8F2)
        )

        Text(
            text = "Versión : 1.0.0",

            color = softGray,

            fontSize = 11.sp,

            fontFamily = Inter,

            fontWeight = FontWeight.Normal,

            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 34.dp)
                .alpha(contentAlpha.value)
        )
    }

}