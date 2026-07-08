package sv.uca.nexauca.presentation.screens.settings

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.repositories.impl.UserRepositoryImpl
import sv.uca.nexauca.presentation.core.events.UIEvent
import sv.uca.nexauca.presentation.core.notifier.NexaToastType
import sv.uca.nexauca.presentation.core.notifier.ToastSonner
import sv.uca.nexauca.presentation.core.state.ResultState



class SettingsViewModel: ViewModel() {



    private val studentRepository = UserRepositoryImpl()

    private val _events = MutableSharedFlow<UIEvent>()

    val events = _events.asSharedFlow()

    val authService = FirebaseAuth.getInstance()

    private val _uiState = MutableStateFlow(SettingsUIState())
    val uiState = _uiState.asStateFlow()

    init {
        loadStudentData()
    }

    private fun loadStudentData () {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }

            val result = studentRepository.getDataStudent()

            when (result) {
                is ResultState.Success -> {
                    _uiState.update { it.copy(isLoading = false, student = result.data) }
                }
                is ResultState.Error -> {
                    _uiState.update { it.copy(isLoading = false) }
                    _events.emit(UIEvent.ShowToast(
                        ToastSonner(
                            title = "Error",
                            message = "${result.message}",
                            type = NexaToastType.ERROR
                        )
                    ))
                }
                is ResultState.Loading -> {
                    _uiState.update { it.copy(isLoading = true) }
                }
            }
        }
    }

    fun toggleNotification(isEnabled: Boolean) {
        _uiState.update { it.copy(isNotificationsEnabled = isEnabled) }
    }

    fun toggleLocation (isEnabled: Boolean) {
        _uiState.update {it.copy(isLocationEnabled = isEnabled)}
    }

    fun onLogout() {
        viewModelScope.launch {
            try {
                authService.signOut()

                _events.emit(UIEvent.NavigateToLogin)
            } catch (e: Exception) {
                _events.emit(UIEvent.ShowToast(
                    ToastSonner(
                        title = "Error",
                        message = "No se pudo cerrarla sesión",
                        type = NexaToastType.ERROR
                    )
                ))
            }
        }
    }

}