package sv.uca.nexauca.data.repositories.api



import sv.uca.nexauca.data.models.ProjectSchedule

interface ProjectScheduleRepository {

    suspend fun getSchedulesByParticipant(
        participantId: String
    ): List<ProjectSchedule>

}