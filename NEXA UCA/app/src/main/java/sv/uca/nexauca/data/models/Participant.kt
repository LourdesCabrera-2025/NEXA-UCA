package sv.uca.nexauca.data.models


data class Participant(

    val id: String,

    val projectId: String,

    val status: String,

    val accumulateHours: Double,

    val projectName: String,

    val latitude: Double,

    val longitude: Double,

    val allowedRadius: Double,

    val maxHoursPerDay: Int,

    val totalRequiredHours: Int,

    val isActive: Boolean
)