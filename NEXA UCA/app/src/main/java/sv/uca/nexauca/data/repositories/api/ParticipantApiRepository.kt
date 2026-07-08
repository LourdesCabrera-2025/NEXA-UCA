package sv.uca.nexauca.data.repositories.api



import sv.uca.nexauca.data.models.Participant
import java.util.UUID

interface ParticipantRepository {

    suspend fun getActiveParticipant(
        studentId: String
    ): Participant?

}