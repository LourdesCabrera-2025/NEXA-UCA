package sv.uca.nexauca.data.models

import kotlinx.serialization.Serializable



@Serializable
data class Attendance (
    val id: String,
    val participantId: String,
    val checkIn: String,
    val checkOut: String?,
    val latitude: Double,
    val longitude: Double,
    val status: AttendanceStatus

)