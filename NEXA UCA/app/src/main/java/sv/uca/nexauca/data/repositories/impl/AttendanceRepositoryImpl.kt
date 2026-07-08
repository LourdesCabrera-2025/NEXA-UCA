package sv.uca.nexauca.data.repositories.impl



import com.google.firebase.Timestamp
import sv.uca.nexauca.data.database.Dao.AttendanceDao
import sv.uca.nexauca.data.firebase.AttendanceProvider
import sv.uca.nexauca.data.mappers.AttendanceMapper
import sv.uca.nexauca.data.models.Attendance
import sv.uca.nexauca.data.models.AttendanceStatus
import sv.uca.nexauca.data.repositories.api.AttendanceApiRepository
import java.util.UUID

class AttendanceRepositoryImpl(

    private val provider: AttendanceProvider,
    private val dao: AttendanceDao

) : AttendanceApiRepository {

    override suspend fun createAttendance(
        attendance: Attendance
    ) {

        provider.createAttendance(
            participantId = UUID.fromString(attendance.participantId),
            checkIn = Timestamp(attendance.checkIn.toLong(), 0),
            latitude = attendance.latitude,
            longitude = attendance.longitude,
            status = attendance.status.name
        )

        dao.insert(
            AttendanceMapper.toEntity(attendance)
        )
    }

    override suspend fun updateAttendanceStatus(
        id: String,
        status: AttendanceStatus
    ) {

        provider.updateAttendanceStatus(
            UUID.fromString(id),
            status.name
        )

        dao.getAttendanceById(id)?.let {

            dao.update(
                it.copy(
                    status = status.name
                )
            )
        }
    }

    override suspend fun updateAttendanceCheckOut(
        id: String,
        checkOut: String
    ) {

        provider.updateAttendanceCheckOut(
            UUID.fromString(id),
            Timestamp(checkOut.toLong(),0)
        )

        dao.getAttendanceById(id)?.let {

            dao.update(
                it.copy(
                    checkOut = checkOut
                )
            )
        }

    }

    override suspend fun getActiveAttendanceById(
        id: String
    ): Attendance? {

        val local = dao.getAttendanceById(id)

        return local?.let {

            AttendanceMapper.toDomain(it)
        }

    }

    override suspend fun getActiveAttendance(
        participantId: String
    ): Attendance? {

        val result = provider.getActiveAttendance(
            UUID.fromString(participantId)
        )

        val attendance = result.data.attendances.firstOrNull()
            ?: return null

        val domain = AttendanceMapper.fromFirebase(
            attendance
        )

        dao.insert(
            AttendanceMapper.toEntity(domain)
        )

        return domain

    }

    override suspend fun saveLocalAttendance(
        attendance: Attendance
    ) {

        dao.insert(
            AttendanceMapper.toEntity(attendance)
        )

    }

    override suspend fun getLocalAttendance(): Attendance? {

        val entity = dao.getCurrentAttendance()

        return entity?.let {

            AttendanceMapper.toDomain(it)

        }

    }

    override suspend fun clearLocalAttendance() {

        dao.deleteCurrentAttendance()

    }

}