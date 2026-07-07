package sv.uca.nexauca.presentation.core.navigation

import kotlinx.serialization.Serializable


/**
 *  Define las rutas de navegación de la aplicación NEXA UCA
 *
 *  Este archivo utiliza la serialización de kotlin para proporcionar una navegación
 *  con seguridad de tipos (Type-safe navigation). Cada objeto representa un destino
 *  único dentro del grafo de navegación de Jetpack Compose
 */

/**
 *  Ruta de la pantalla de bienvenida (Splash Screen).
 *  Es el punto de entrada inicial de la aplicación donde se realizan
 *  validación rápidas o se muestra el branding
 */
@Serializable
data object SplashRoute

/**
 * Ruta de la pantalla de Inicio de sesión
 * Dirige al usuario o a la interfaz de autenticación institucional.
 */
@Serializable

data object AppLoginRoute

/**
 *  Ruta del panel principal (Dashboard)
 *  Es el destino principal una vez que el usuario ha sido autenticado con éxito
 */

@Serializable

data object MainDashboardRoute

@Serializable
data object StudentProductivity

@Serializable
data object SettingsAccount
