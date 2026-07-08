import type { CreateProjectVariables, GetProjectByIdData } from "@/dataconnect-generated";
import type { Project } from "@/models/Program";
import type { ProjectDetail } from "@/models/ProjectDetail";

export const ProgramMapper = {

    toDomain: (data: any): Project => {
        return {
            name: data.name,
            description: data.description || "",
            projectTypeId: data.projectTypeId || "",
            supervisorId: data.supervisorId || "",
            startDate: new Date(data.startDate),
            endDate: new Date(data.endDate),
            latitude: Number(data.latitude),
            longitude: Number(data.longitude),
            allowedRadius: Number(data.allowedRadius),
            maxStudents: Number(data.maxStudents),
            maxHoursPerDay: Number(data.maxHoursPerDay ?? 5),
            totalRequiredHours: Number(data.totalRequiredHours),
            isActive: Boolean(data.isActive),
        };
    },

    fromGetProjectById(
        data: NonNullable<GetProjectByIdData['project']>
    ): ProjectDetail {

        return {
            name: data.name,
            description: data.description ?? "",

            projectType: {
                id: data.projectType.id,
                name: data.projectType.name
            },

            supervisor: {
                id: data.supervisor.id,
                fullName: data.supervisor.fullName
            },

            startDate: new Date(data.startDate),
            endDate: new Date(data.endDate),
            latitude: data.latitude,
            longitude: data.longitude,
            allowedRadius: data.allowedRadius,
            maxStudents: data.maxStudents,
            maxHoursPerDay: data.maxHoursPerDay,
            totalRequiredHours: data.totalRequiredHours,
            isActive: data.isActive
        };
    },

    toPersistance: (project: Project): CreateProjectVariables => {
        return {
            name: project.name,
            description: project.description || "",
            projectTypeId: project.projectTypeId,
            supervisorId: project.supervisorId,
            startDate: project.startDate.toISOString().split('T')[0],
            endDate: project.endDate.toISOString().split('T')[0],
            latitude: Number(project.latitude),
            longitude: Number(project.longitude),
            allowedRadius: Number(project.allowedRadius),
            maxStudents: Number(project.maxStudents),
            totalRequiredHours: Number(project.totalRequiredHours),
            isActive: project.isActive
        };
    },
}
