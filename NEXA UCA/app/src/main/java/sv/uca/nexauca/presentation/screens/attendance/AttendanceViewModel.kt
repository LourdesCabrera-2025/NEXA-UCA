package sv.uca.nexauca.presentation.screens.attendance



import android.annotation.SuppressLint
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import sv.uca.nexauca.data.firebase.FirebaseModule

data class AttendanceUiState(

    val elapsedTime: String = "00:00:00",

    val projectName: String = "Proyecto de Horas Sociales",

    val insideArea: Boolean = true,

    val running: Boolean = true,

    val loading: Boolean = false,

    val finished: Boolean = false

)

class AttendanceViewModel : ViewModel() {

    private val attendanceService by lazy {

        FirebaseModule.attendanceService

    }

    private val _state = MutableStateFlow(
        AttendanceUiState()
    )

    val state: StateFlow<AttendanceUiState> =
        _state.asStateFlow()

    @SuppressLint("DefaultLocale")
    fun startAttendance() {

        viewModelScope.launch {

            var seconds = 0

            while (_state.value.running) {

                delay(1000)

                seconds++

                val hours = seconds / 3600
                val minutes = (seconds % 3600) / 60
                val secs = seconds % 60

                _state.value = _state.value.copy(

                    elapsedTime = String.format(

                        "%02d:%02d:%02d",

                        hours,

                        minutes,

                        secs

                    )

                )

            }

        }

    }

    fun finishAttendance() {

        viewModelScope.launch {

            _state.value = _state.value.copy(

                running = false,

                loading = true

            )

            delay(800)

            _state.value = _state.value.copy(

                loading = false,

                finished = true

            )

        }

    }

}