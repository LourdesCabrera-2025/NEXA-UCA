import type { CreateProjectVariables } from "@/dataconnect-generated";
import type { Project } from "@/models/Program";

export const ProgramMapper = {

    toDomain: (data:any) : Project => {
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
            totalRequiredHours: Number(data.totalRequiredHours ),
            isActive: Boolean(data.isActive),
        };
    },

    toPersistance: (project: Project) : CreateProjectVariables => {
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
            totalRequiredHours: Number(project.totalRequiredHours ),
            isActive: project.isActive
        };
    },
}
