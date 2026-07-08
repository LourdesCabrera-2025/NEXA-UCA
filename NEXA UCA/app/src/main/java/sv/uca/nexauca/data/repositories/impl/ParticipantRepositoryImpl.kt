package sv.uca.nexauca.data.repositories.impl


import sv.uca.nexauca.data.firebase.ParticipantProvider
import sv.uca.nexauca.data.mappers.ParticipantMapper
import sv.uca.nexauca.data.models.Participant
import sv.uca.nexauca.data.repositories.api.ParticipantRepository
import java.util.UUID

class ParticipantRepositoryImpl(

    private val provider: ParticipantProvider

) : ParticipantRepository {

    override suspend fun getActiveParticipant(studentId: String): Participant? {

        val result = provider.getParticipantValidation(UUID.fromString(studentId))

        val participant =
            result.data.participants.firstOrNull()
                ?: return null

        return ParticipantMapper.fromFirebase(participant)
    }


}