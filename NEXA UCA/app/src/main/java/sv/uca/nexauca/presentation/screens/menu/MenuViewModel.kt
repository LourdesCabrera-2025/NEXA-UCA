package sv.uca.nexauca.presentation.screens.menu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import sv.uca.nexauca.data.repositories.impl.UserRepositoryImpl
import sv.uca.nexauca.presentation.core.events.UIEvent
import sv.uca.nexauca.presentation.core.state.ResultState
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.presentation.core.notifier.NexaToastType
import sv.uca.nexauca.presentation.core.notifier.ToastSonner


class MenuViewModel : ViewModel() {


    private val studentRepository = UserRepositoryImpl()
    private val _events = MutableSharedFlow<UIEvent>()

    val events = _events.asSharedFlow()

    private val _uiState = MutableStateFlow(MenuUIState())
    val uiState = _uiState.asStateFlow()


    fun getDataStudent(){

        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(
                isLoading = true
            )

            when(val result = studentRepository.getDataStudent()) {
                is ResultState.Success -> {
                    _uiState.value = MenuUIState(
                        isLoading = false,
                        student = result.data
                    )
                }

                is ResultState.Error -> {

                    _uiState.value = _uiState.value.copy(
                        isLoading = false
                    )

                    _events.emit(
                        UIEvent.ShowToast(
                            ToastSonner(
                                title = "Error",
                                message = "No se pudo cargar la información del estudiante",
                                type = NexaToastType.ERROR
                            )
                        )
                    )
                }

                else -> {
                    _uiState.value = _uiState.value.copy(
                        isLoading = false
                    )
                }
            }
        }
    }

}