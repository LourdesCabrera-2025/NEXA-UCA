package sv.uca.nexauca.data.firebase


import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.dataconnect.instance
import java.util.UUID

class ProjectScheduleProvider(

    private val connector: NexaConnector = NexaConnector.instance

) {

    suspend fun getProjectScheduleByParticipant(
        participantId: UUID
    ) =
        connector.getProjectSchedules.execute(
            participantId = participantId
        )

}