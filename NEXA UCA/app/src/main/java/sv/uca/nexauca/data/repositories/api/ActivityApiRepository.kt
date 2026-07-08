package sv.uca.nexauca.data.repositories.api

import sv.uca.nexauca.data.models.Activity

interface ActivityApiRepository {

    suspend fun createActivity(
        activity: Activity
    )

    suspend fun updateActivity(
        id: String,
        approved: Boolean
    )

    suspend fun getActivityByAttendance(
        attendanceId: String
    ): Activity?

    suspend fun saveLocalActivity(
        activity: Activity
    )

    suspend fun getLocalActivities(): List<Activity>

    suspend fun clearLocalActivities()
}