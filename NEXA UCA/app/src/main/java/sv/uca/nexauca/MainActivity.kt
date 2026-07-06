package sv.uca.nexauca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.core.view.WindowCompat
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth
import sv.uca.nexauca.presentation.core.navigation.AppLoginRoute
import sv.uca.nexauca.presentation.core.navigation.MainDashboardRoute
import sv.uca.nexauca.presentation.core.navigation.SplashRoute
import sv.uca.nexauca.presentation.core.navigation.StudentProductivity
import sv.uca.nexauca.presentation.screens.login.LoginScreen
import sv.uca.nexauca.presentation.screens.menu.MenuScreen
import sv.uca.nexauca.presentation.screens.productivity.Productivity
import sv.uca.nexauca.presentation.screens.splash.SplashScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        WindowCompat.getInsetsController(window, window.decorView).apply { isAppearanceLightStatusBars = true }
        setContent {
            val startRoute = remember {
                if (FirebaseAuth.getInstance().currentUser != null) {
                    MainDashboardRoute
                } else {
                    SplashRoute
                }
            }
            val backStack = remember {
                mutableStateListOf<Any>(startRoute)
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
                                onNavigateLogin = {
                                    backStack.clear()
                                    backStack.add(AppLoginRoute)
                                },
                                onNavigateHome = {
                                    backStack.clear()
                                    backStack.add(MainDashboardRoute)
                                }
                            )
                        }

                        AppLoginRoute -> NavEntry(key) {
                            LoginScreen(
                                onNavigateHome = {
                                    backStack.clear()
                                    backStack.add(MainDashboardRoute)
                                }
                            )
                        }

                        MainDashboardRoute -> NavEntry(key) {
                            MenuScreen(
                                onNavigateToProductivity = {
                                    backStack.clear()
                                    backStack.add(StudentProductivity)
                                }
                            )
                        }

                        StudentProductivity -> NavEntry(key) {
                            Productivity()
                        }
                        else -> error("Ruta desconocida: $key")
                    }
                }
            )
        }
    }
}
