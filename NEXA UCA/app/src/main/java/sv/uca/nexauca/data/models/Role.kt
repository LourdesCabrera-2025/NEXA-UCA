package sv.uca.nexauca.data.models

import kotlinx.serialization.Serializable

@Serializable
data class Role(
    val id: String,
    val name: String
)