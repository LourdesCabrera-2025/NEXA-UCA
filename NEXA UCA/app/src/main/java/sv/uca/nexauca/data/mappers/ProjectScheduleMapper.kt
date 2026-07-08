package sv.uca.nexauca.data.mappers



import sv.uca.nexauca.data.models.ProjectSchedule
import sv.uca.nexauca.dataconnect.GetProjectSchedulesQuery

object ProjectScheduleMapper {

    fun fromFirebase(
        schedule: GetProjectSchedulesQuery.Data.ProjectSchedulesItem
    ): ProjectSchedule {

        return ProjectSchedule(
            id = schedule.id.toString(),
            dayOfWeek = schedule.dayOfWeek,
            startHour = schedule.startHour,
            endHour = schedule.endHour
        )
    }
}