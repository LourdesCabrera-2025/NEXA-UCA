package sv.uca.nexauca.data.models



import kotlinx.serialization.Serializable


@Serializable
data class Student (
    val id: String,
    val studentCode: String,
    val phoneNumber: String?,
    val birthDate: String?,
    val userId: String,
    val email: String,
    val fullName: String,
    val photoUrl: String?,
    val isActive: Boolean,
    val role: Role,
    val career: Career?
)
