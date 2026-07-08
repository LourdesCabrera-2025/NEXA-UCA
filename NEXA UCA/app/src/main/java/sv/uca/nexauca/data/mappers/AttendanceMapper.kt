package sv.uca.nexauca.data.mappers

import sv.uca.nexauca.data.database.Dao.entities.AttendanceEntity
import sv.uca.nexauca.data.models.Attendance
import sv.uca.nexauca.data.models.AttendanceStatus
import sv.uca.nexauca.dataconnect.GetActiveAttendanceQuery

object AttendanceMapper {

    fun toEntity(
        attendance: Attendance
    ): AttendanceEntity {

        return AttendanceEntity(
            id = attendance.id,
            participantId = attendance.participantId,
            checkIn = attendance.checkIn,
            checkOut = attendance.checkOut,
            latitude = attendance.latitude,
            longitude = attendance.longitude,
            status = attendance.status.name
        )
    }

    fun toDomain(
        entity: AttendanceEntity
    ): Attendance {

        return Attendance(
            id = entity.id,
            participantId = entity.participantId,
            checkIn = entity.checkIn,
            checkOut = entity.checkOut,
            latitude = entity.latitude,
            longitude = entity.longitude,
            status = AttendanceStatus.valueOf(entity.status)
        )
    }


    fun fromFirebase(
        attendance: GetActiveAttendanceQuery.Data.AttendancesItem
    ): Attendance {

        return Attendance(
            id = attendance.id.toString(),
            participantId = attendance.participantId.toString(),
            checkIn = attendance.checkIn.toDate().time.toString(),
            checkOut = attendance.checkOut?.toDate()?.time?.toString(),
            latitude = attendance.latitude,
            longitude = attendance.longitude,
            status = AttendanceStatus.valueOf(attendance.status)
        )
    }
}