package sv.uca.nexauca.data.firebase



import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.dataconnect.instance
import java.util.UUID

class ParticipantProvider(

    private val connector: NexaConnector = NexaConnector.instance

) {

    suspend fun getParticipantValidation(
        studentId: UUID
    ) =
        connector.getParticipantValidation.execute(
            studentId = studentId
        )

}