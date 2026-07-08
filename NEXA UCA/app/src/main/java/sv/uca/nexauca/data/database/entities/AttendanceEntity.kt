package sv.uca.nexauca.data.database.Dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "attendance")
data class AttendanceEntity(
    @PrimaryKey
    val id: String,
    val participantId: String,
    val checkIn: String,
    val checkOut: String?,
    val latitude: Double,
    val longitude: Double,
    val status: String
)
