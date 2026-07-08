package sv.uca.nexauca.data.services.attendance

import android.os.Build
import androidx.annotation.RequiresApi
import sv.uca.nexauca.data.models.Attendance
import sv.uca.nexauca.data.models.AttendanceStatus
import sv.uca.nexauca.data.services.validation.ValidationResult
import sv.uca.nexauca.data.repositories.api.AttendanceApiRepository
import sv.uca.nexauca.data.services.gps.GpsService
import sv.uca.nexauca.data.services.validation.ValidationService
import java.time.Instant
import java.util.UUID

class AttendanceService(

    private val validationService: ValidationService,
    private val gpsService: GpsService,
    private val attendanceRepository: AttendanceApiRepository

) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun startAttendance(): ValidationResult {

        val validation = validationService.validateStudent()

        if (validation !is ValidationResult.Success) {
            return validation
        }

        val participant = validation.participant

        val location = gpsService.getCurrentLocation()
            ?: return ValidationResult.OutOfRange

        val inside = gpsService.isInsideRadius(
            currentLatitude = location.latitude,
            currentLongitude = location.longitude,
            projectLatitude = participant.latitude,
            projectLongitude = participant.longitude,
            allowedRadius = participant.allowedRadius
        )

        if (!inside) {
            return ValidationResult.OutOfRange
        }

        attendanceRepository.createAttendance(
            Attendance(
                id = UUID.randomUUID().toString(),
                participantId = participant.id,
                checkIn = Instant.now().toString(),
                checkOut = null,
                latitude = location.latitude,
                longitude = location.longitude,
                status = AttendanceStatus.Pendiente
            )
        )

        return validation
    }
}