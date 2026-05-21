package sv.uca.nexauca.features.splash

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class  SplashScreenViewModel :  ViewModel() {

    var loadingMessage by mutableStateOf("Inicializando módulos")
        private set

    var progress by mutableStateOf(0f)
        private set

    var isFinished by mutableStateOf(false)
        private set

    fun startLoading() {
        viewModelScope.launch {
            updateLoading("Cargando registros", 0.20f)
            updateLoading("Sincronizando notificaciones", 0.30f)
            updateLoading("Preparando servicios GPS", 0.60f)
            updateLoading("Verificando sesión", 0.90f)
            updateLoading("Preparando dashboard", 1.00f)

            delay(900)
            isFinished = true
        }
    }

    private suspend fun updateLoading(message: String, targetProgress: Float) {
        loadingMessage = message
        progress = targetProgress
        delay(1600)
    }
}