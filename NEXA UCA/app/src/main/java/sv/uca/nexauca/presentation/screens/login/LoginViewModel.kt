package sv.uca.nexauca.presentation.screens.login

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.repositories.impl.RoleRepositoryImpl
import sv.uca.nexauca.data.repositories.impl.SessionRepository
import sv.uca.nexauca.data.repositories.impl.UserRepositoryImpl
import sv.uca.nexauca.data.services.auth.AuthService
import sv.uca.nexauca.presentation.core.events.UIEvent
import sv.uca.nexauca.presentation.core.notifier.NexaToastType
import sv.uca.nexauca.presentation.core.notifier.ToastSonner
import sv.uca.nexauca.presentation.core.state.ResultState
import sv.uca.nexauca.presentation.core.utils.StudentCodeGenerator



class LoginViewModel : ViewModel() {

    private val authService = AuthService()
    private val sessionRepository = SessionRepository()

    private val _events = MutableSharedFlow<UIEvent>()
    val events = _events.asSharedFlow()


    fun loginWithMicrosoft(activity: Activity) {
        viewModelScope.launch {
            try {
                showToast(
                    title = "Microsoft",
                    message = "Abriendo inicio de sesión...",
                    type = NexaToastType.INFO
                )

                val firebaseUser = authService.loginWithMicrosoft(activity)
                when(val sessionResult = sessionRepository.ensureUserAndStudent(firebaseUser)) {
                    is ResultState.Success -> {
                        showToast(
                            title = "Bienvenida",
                            message = "Inicio de sesión exitoso",
                            type = NexaToastType.SUCCESS
                        )

                        _events.emit(UIEvent.NavigateToHome)
                    }
                    is ResultState.Error -> {
                        showToast(
                            title = "Error",
                            message = sessionResult.message,
                            type = NexaToastType.ERROR
                        )
                    }
                    else -> Unit
                }

            }catch (e: Exception) {
                showToast(
                    title = "Error",
                    message = e.message ?: "No se pudo iniciar sesión con Microsoft",
                    type = NexaToastType.ERROR
                )
            }
        }
    }

    private suspend fun showToast (
        title: String,
        message: String,
        type: NexaToastType
    ) {
        _events.emit(
            UIEvent.ShowToast(
                ToastSonner(
                    title = title,
                    message = message,
                    type = type
                )
            )
        )
    }
}

