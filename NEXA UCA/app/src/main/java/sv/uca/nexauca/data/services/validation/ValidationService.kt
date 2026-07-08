package sv.uca.nexauca.data.services.validation

import android.location.Location
import android.os.Build
import androidx.annotation.RequiresApi
import sv.uca.nexauca.data.firebase.FirebaseModule
import sv.uca.nexauca.data.services.validation.ValidationResult
import sv.uca.nexauca.data.repositories.api.ParticipantRepository
import sv.uca.nexauca.data.repositories.api.ProjectScheduleRepository
import sv.uca.nexauca.data.repositories.api.StudentApiRepository
import sv.uca.nexauca.presentation.core.state.ResultState
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.LocalTime

class ValidationService(

    private val studentRepository: StudentApiRepository,
    private val participantRepository: ParticipantRepository,
    private val scheduleRepository: ProjectScheduleRepository

) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun validateStudent(): ValidationResult {

        // Obtener el estudiante autenticado
        val studentResult = studentRepository.getMyStudent()

        if (studentResult !is ResultState.Success) {
            return ValidationResult.ParticipantNotFound
        }

        val student = studentResult.data

        // Buscar la inscripción del estudiante
        val participant =
            participantRepository.getActiveParticipant(student.id)
                ?: return ValidationResult.ParticipantNotFound


        if (!participant.isActive) {
            return ValidationResult.ProjectInactive
        }


        val schedules =
            scheduleRepository.getSchedulesByParticipant(participant.id)


        val currentDay = when (LocalDateTime.now().dayOfWeek) {
            DayOfWeek.MONDAY -> 1
            DayOfWeek.TUESDAY -> 2
            DayOfWeek.WEDNESDAY -> 3
            DayOfWeek.THURSDAY -> 4
            DayOfWeek.FRIDAY -> 5
            DayOfWeek.SATURDAY -> 6
            DayOfWeek.SUNDAY -> 7
        }


        val todaySchedule = schedules.firstOrNull {
            it.dayOfWeek == currentDay
        } ?: return ValidationResult.InvalidDay


        val now = LocalTime.now()

        val startHour = LocalTime.parse(todaySchedule.startHour)
        val endHour = LocalTime.parse(todaySchedule.endHour)


        if (now.isBefore(startHour) || now.isAfter(endHour)) {
            return ValidationResult.InvalidHour
        }

        val location = FirebaseModule.gpsService
            .getCurrentLocation()
            ?: return ValidationResult.OutOfRange

        val distance = FloatArray(1)

        Location.distanceBetween(

            location.latitude,

            location.longitude,

            participant.latitude,

            participant.longitude,

            distance

        )

        if(distance[0] > participant.allowedRadius){

            return ValidationResult.OutOfRange

        }


        return ValidationResult.Success(participant)
    }
}