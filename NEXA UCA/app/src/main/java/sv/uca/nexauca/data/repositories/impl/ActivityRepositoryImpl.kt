package sv.uca.nexauca.data.repositories.impl

import sv.uca.nexauca.data.database.Dao.ActivityDao
import sv.uca.nexauca.data.firebase.ActivityProvider
import sv.uca.nexauca.data.mappers.ActivityMapper
import sv.uca.nexauca.data.models.Activity
import sv.uca.nexauca.data.repositories.api.ActivityApiRepository
import java.util.UUID

class ActivityRepositoryImpl(

    private val provider: ActivityProvider,
    private val dao: ActivityDao

) : ActivityApiRepository {

    override suspend fun createActivity(
        activity: Activity
    ) {

        provider.createActivity(
            attendanceId = UUID.fromString(activity.attendanceId),
            title = activity.title,
            description = activity.description
        )

        dao.insert(
            ActivityMapper.toEntity(activity)
        )
    }

    override suspend fun updateActivity(
        id: String,
        approved: Boolean
    ) {

        provider.updateActivity(
            id = UUID.fromString(id),
            approved = approved
        )

        dao.getActivityById(id)?.let { entity ->

            dao.update(
                entity.copy(
                    approved = approved
                )
            )
        }
    }

    override suspend fun getActivityByAttendance(
        attendanceId: String
    ): Activity? {

        val local = dao.getActivityByAttendance(attendanceId)

        if (local != null) {
            return ActivityMapper.toDomain(local)
        }

        val result = provider.getActivityByAttendance(
            UUID.fromString(attendanceId)
        )

        val firebaseActivity =
            result.data.activities.firstOrNull()
                ?: return null

        val activity = ActivityMapper.fromFirebase(
            firebaseActivity
        )

        dao.insert(
            ActivityMapper.toEntity(activity)
        )

        return activity
    }

    override suspend fun saveLocalActivity(
        activity: Activity
    ) {

        dao.insert(
            ActivityMapper.toEntity(activity)
        )
    }

    override suspend fun getLocalActivities(): List<Activity> {

        return dao.getActivities().map {

            ActivityMapper.toDomain(it)

        }
    }

    override suspend fun clearLocalActivities() {

        dao.deleteAll()

    }
}