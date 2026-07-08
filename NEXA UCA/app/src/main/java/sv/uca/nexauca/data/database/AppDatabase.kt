package sv.uca.nexauca.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import sv.uca.nexauca.data.database.Dao.ActivityDao
import sv.uca.nexauca.data.database.Dao.AttendanceDao
import sv.uca.nexauca.data.database.Dao.entities.ActivityEntity
import sv.uca.nexauca.data.database.Dao.entities.AttendanceEntity

@Database(
    entities = [
        AttendanceEntity::class,
        ActivityEntity::class
    ],
    version = 1,
    exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {
    abstract fun attendanceDao(): AttendanceDao

    abstract fun activityDao(): ActivityDao
}