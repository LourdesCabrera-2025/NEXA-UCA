package sv.uca.nexauca.presentation.attendance.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.firebase.FirebaseModule
import sv.uca.nexauca.data.services.validation.ValidationResult

data class ValidationUiState(

    val studentValidated: Boolean = false,

    val projectValidated: Boolean = false,

    val scheduleValidated: Boolean = false,

    val locationValidated: Boolean = false,

    val finished: Boolean = false,

    val error: String? = null

)

class ValidationViewModel : ViewModel() {

    private val validationService by lazy {

        FirebaseModule.validationService

    }

    private val _state = MutableStateFlow(
        ValidationUiState()
    )

    val state: StateFlow<ValidationUiState> =
        _state.asStateFlow()

    @RequiresApi(Build.VERSION_CODES.O)
    fun startValidation() {

        viewModelScope.launch {

            _state.value = ValidationUiState()

            delay(500)


            _state.value = _state.value.copy(
                studentValidated = true
            )

            delay(500)


            _state.value = _state.value.copy(
                projectValidated = true
            )

            delay(500)

            val result = validationService.validateStudent()

            when (result) {

                is ValidationResult.Success -> {

                    _state.value = _state.value.copy(

                        scheduleValidated = true,

                        locationValidated = true,

                        finished = true

                    )

                }

                is ValidationResult.InvalidDay -> {

                    _state.value = _state.value.copy(

                        error = "Hoy no tienes una jornada programada."

                    )

                }

                is ValidationResult.InvalidHour -> {

                    _state.value = _state.value.copy(

                        error = "No estás dentro del horario permitido."

                    )

                }

                is ValidationResult.OutOfRange -> {

                    _state.value = _state.value.copy(

                        scheduleValidated = true,

                        error = "Debes encontrarte dentro del área autorizada."

                    )

                }

                is ValidationResult.ProjectInactive -> {

                    _state.value = _state.value.copy(

                        error = "El proyecto está inactivo."

                    )

                }

                is ValidationResult.ParticipantNotFound -> {

                    _state.value = _state.value.copy(

                        error = "No tienes una inscripción activa."

                    )

                }

            }

        }

    }

}