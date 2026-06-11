package sv.uca.nexauca.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Department(
    val id: String,
    val name: String
)
