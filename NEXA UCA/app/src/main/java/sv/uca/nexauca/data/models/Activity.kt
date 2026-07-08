package sv.uca.nexauca.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Activity(
    val id: String,
    val attendanceId: String,
    val title: String,
    val description: String,
    val approved: Boolean,
    val createdAt: String
)