package sv.uca.nexauca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import sv.uca.nexauca.core.navigation.AppLoginRoute
import sv.uca.nexauca.core.navigation.SplashRoute
import sv.uca.nexauca.features.login.LoginScreen
import sv.uca.nexauca.features.splash.SplashScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val backStack = remember {
                mutableStateListOf<Any>(SplashRoute)
            }

            NavDisplay(
                backStack = backStack,
                onBack = {
                    if (backStack.size > 1) {
                        backStack.removeLastOrNull()
                    }
                },
                entryProvider = { key->
                    when(key) {
                        SplashRoute -> NavEntry(key) {
                            SplashScreen(
                                onSplashFinished = {
                                    backStack.clear()
                                    backStack.add(AppLoginRoute)
                                }
                            )
                        }

                        AppLoginRoute -> NavEntry(key) {
                            LoginScreen()
                        }
                        else -> error("Ruta desconocida: $key")
                    }
                }
            )
        }
    }
}
