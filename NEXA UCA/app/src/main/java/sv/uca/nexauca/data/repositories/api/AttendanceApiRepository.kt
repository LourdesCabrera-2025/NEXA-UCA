package sv.uca.nexauca.data.repositories.api

import sv.uca.nexauca.data.models.Attendance
import sv.uca.nexauca.data.models.AttendanceStatus

interface AttendanceApiRepository {

    suspend fun createAttendance(
        attendance: Attendance
    )

    suspend fun updateAttendanceStatus(
        id: String,
        status: AttendanceStatus
    )

    suspend fun updateAttendanceCheckOut(
        id: String,
        checkOut: String
    )

    suspend fun getActiveAttendanceById(
        id: String
    ): Attendance?

    suspend fun getActiveAttendance(
        participantId: String
    ): Attendance?

    suspend fun saveLocalAttendance(
        attendance: Attendance
    )

    suspend fun getLocalAttendance(): Attendance?

    suspend fun clearLocalAttendance()
}