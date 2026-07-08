package sv.uca.nexauca.data.firebase



import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.dataconnect.instance
import java.util.UUID

class ActivityProvider(

    private val connector: NexaConnector = NexaConnector.instance

) {

    suspend fun createActivity(
        attendanceId: UUID,
        title: String,
        description: String
    ) =
        connector.createActivity.execute(
            attendanceId = attendanceId,
            title = title,
            description = description
        )

    suspend fun getActivityByAttendance(
        attendanceId: UUID
    ) =
        connector.getActivityByAttendance.execute(
            attendanceId = attendanceId
        )

    suspend fun updateActivity(
        id: UUID,
        approved: Boolean
    ) =
        connector.updateActivity.execute(
            id = id,
            approved = approved
        )
}