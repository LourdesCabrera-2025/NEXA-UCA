package sv.uca.nexauca.data.models

import com.google.firebase.Timestamp
import java.util.UUID

data class ActividadRecienteItem(
    val id: UUID,
    val title: String,
    val approved: Boolean,
    val checkIn: Timestamp,
    val checkOut: Timestamp?,
    val projectName: String,
    val projectType: String
)