package sv.uca.nexauca.data.mappers



import sv.uca.nexauca.data.models.Participant
import sv.uca.nexauca.dataconnect.GetParticipantValidationQuery

object ParticipantMapper {

    fun fromFirebase(
        participant: GetParticipantValidationQuery.Data.ParticipantsItem
    ): Participant {

        return Participant(
            id = participant.id.toString(),
            projectId = participant.project.id.toString(),
            status = participant.status,
            accumulateHours = participant.accumulateHours,
            projectName = participant.project.name,
            latitude = participant.project.latitude,
            longitude = participant.project.longitude,
            allowedRadius = participant.project.allowedRadius,
            maxHoursPerDay = participant.project.maxHoursPerDay,
            totalRequiredHours = participant.project.totalRequiredHours,
            isActive = participant.project.isActive
        )
    }
}