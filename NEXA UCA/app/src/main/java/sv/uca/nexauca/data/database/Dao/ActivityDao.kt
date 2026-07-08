package sv.uca.nexauca.data.database.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import sv.uca.nexauca.data.database.Dao.entities.ActivityEntity

@Dao
interface ActivityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(activity: ActivityEntity)

    @Update
    suspend fun update(activity: ActivityEntity)

    @Delete
    suspend fun delete(activity: ActivityEntity)

    @Query("SELECT * FROM activity")
    suspend fun getActivities(): List<ActivityEntity>

    @Query("SELECT * FROM activity WHERE id = :id LIMIT 1")
    suspend fun getActivityById(id: String): ActivityEntity?

    @Query("SELECT * FROM activity WHERE attendanceId = :attendanceId LIMIT 1")
    suspend fun getActivityByAttendance(attendanceId: String): ActivityEntity?

    @Query("DELETE FROM activity")
    suspend fun deleteAll()
}