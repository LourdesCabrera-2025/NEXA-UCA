package sv.uca.nexauca.data.repositories.impl



import sv.uca.nexauca.data.firebase.ProjectScheduleProvider
import sv.uca.nexauca.data.mappers.ProjectScheduleMapper
import sv.uca.nexauca.data.models.ProjectSchedule
import sv.uca.nexauca.data.repositories.api.ProjectScheduleRepository
import java.util.UUID

class ProjectScheduleRepositoryImpl(

    private val provider: ProjectScheduleProvider

) : ProjectScheduleRepository {

    override suspend fun getSchedulesByParticipant(
        participantId: String
    ): List<ProjectSchedule> {

        val result = provider.getProjectScheduleByParticipant(
            UUID.fromString(participantId)
        )

        return result.data.projectSchedules.map {

            ProjectScheduleMapper.fromFirebase(it)

        }
    }
}