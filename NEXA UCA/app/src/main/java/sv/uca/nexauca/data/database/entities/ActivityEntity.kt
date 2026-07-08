package sv.uca.nexauca.data.database.Dao.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "activity")
data class ActivityEntity(
    @PrimaryKey
    val id: String,
    val attendanceId: String,
    val title: String,
    val description: String,
    val approved: Boolean,
    val createdAt: String
)