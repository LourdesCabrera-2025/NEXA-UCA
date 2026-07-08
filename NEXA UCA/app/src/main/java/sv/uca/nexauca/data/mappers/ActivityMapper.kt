package sv.uca.nexauca.data.mappers

import sv.uca.nexauca.data.database.Dao.entities.ActivityEntity
import sv.uca.nexauca.data.models.Activity
import sv.uca.nexauca.dataconnect.GetActivityByAttendanceQuery


object ActivityMapper {

    fun toEntity(
        activity: Activity
    ): ActivityEntity {
        return ActivityEntity(
            id = activity.id,
            attendanceId = activity.attendanceId,
            title = activity.title,
            description = activity.description,
            approved = activity.approved,
            createdAt = activity.createdAt
        )
    }

    fun toDomain(
        entity: ActivityEntity
    ): Activity {
        return Activity(
            id = entity.id,
            attendanceId = entity.attendanceId,
            title = entity.title,
            description = entity.description,
            approved = entity.approved,
            createdAt = entity.createdAt
        )
    }

    fun fromFirebase(
        activity: GetActivityByAttendanceQuery.Data.ActivitiesItem
    ): Activity {

        return Activity(
            id = activity.id.toString(),
            attendanceId = activity.attendanceId.toString(),
            title = activity.title,
            description = activity.description,
            approved = activity.approved,
            createdAt = activity.createdAt.toString()
        )
    }
}