package sv.uca.nexauca.data.database.Dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import sv.uca.nexauca.data.database.Dao.entities.AttendanceEntity

@Dao
interface AttendanceDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(attendance: AttendanceEntity)

    @Update
    suspend fun update(attendance: AttendanceEntity)

    @Query("SELECT * FROM attendance WHERE id = :id LIMIT 1")
    suspend fun getAttendanceById(id: String): AttendanceEntity?

    @Query("SELECT * FROM attendance LIMIT 1")
    suspend fun getCurrentAttendance(): AttendanceEntity?

    @Query("DELETE FROM attendance")
    suspend fun deleteCurrentAttendance()

}