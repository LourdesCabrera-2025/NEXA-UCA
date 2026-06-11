package sv.uca.nexauca.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Career(
    val id: String,
    val name: String,
    val department: Department
)
