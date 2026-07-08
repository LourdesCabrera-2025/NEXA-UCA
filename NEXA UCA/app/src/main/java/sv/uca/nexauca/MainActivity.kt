package sv.uca.nexauca

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.Surface
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth
import sv.uca.nexauca.presentation.core.navigation.AppLoginRoute
import sv.uca.nexauca.presentation.core.navigation.MainDashboardRoute
import sv.uca.nexauca.presentation.core.navigation.RecentActivityRoute
import sv.uca.nexauca.presentation.core.navigation.SettingsAccount
import sv.uca.nexauca.presentation.core.navigation.SplashRoute
import sv.uca.nexauca.presentation.core.navigation.StudentProductivity
import sv.uca.nexauca.presentation.screens.login.LoginScreen
import sv.uca.nexauca.presentation.screens.menu.MenuScreen
import sv.uca.nexauca.presentation.screens.productivity.HistorialActividadesScreen
import sv.uca.nexauca.presentation.screens.productivity.Productivity
import sv.uca.nexauca.presentation.screens.settings.Settings
import sv.uca.nexauca.presentation.screens.splash.SplashScreen
import sv.uca.nexauca.presentation.screens.productivity.HistorialActividadesViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

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

            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .windowInsetsPadding(WindowInsets.systemBars)
            ) {
                NavDisplay(
                    backStack = backStack,
                    onBack = {
                        if (backStack.size > 1) {
                            backStack.removeLastOrNull()
                        }
                    },
                    entryProvider = { key ->
                        when (key) {
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
                                        backStack.add(StudentProductivity)
                                    },
                                    onNavigateToSettings = {
                                        backStack.add(SettingsAccount)
                                    }
                                )
                            }

                            StudentProductivity -> NavEntry(key) {
                                Productivity(
                                    onBackClick = { backStack.removeLastOrNull() },
                                    onVerTodasClick = {
                                        backStack.add(RecentActivityRoute)
                                    }
                                )
                            }

                            RecentActivityRoute -> NavEntry(key) {
                                val viewModel: HistorialActividadesViewModel = viewModel()
                                val uiState by viewModel.uiState.collectAsState()

                                HistorialActividadesScreen(
                                    estadisticas = uiState.estadisticas,
                                    grupos = uiState.grupos,
                                    query = uiState.query,
                                    onQueryChange = viewModel::onQueryChange,
                                    estadoSeleccionado = uiState.estadoSeleccionado,
                                    onEstadoSelected = viewModel::onEstadoSelected,
                                    ordenSeleccionado = uiState.ordenSeleccionado,
                                    onOrdenSelected = viewModel::onOrdenSelected,
                                    onLimpiarFiltros = viewModel::onLimpiarFiltros,
                                    onBackClick = { backStack.removeLastOrNull() }
                                )
                            }



                            SettingsAccount -> NavEntry(key) {
                                Settings(
                                    onNavigateToHome = {
                                        backStack.add(MainDashboardRoute)
                                    },
                                    onNavigateToLogin = {
                                        backStack.clear()
                                        backStack.add(AppLoginRoute)
                                    }
                                )
                            }

                            else -> error("Ruta desconocida: $key")
                        }
                    }
                )
            }
        }
    }
}