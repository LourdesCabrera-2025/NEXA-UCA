import type { CreateProjectCareerVariables } from "@/dataconnect-generated";
import type { ProjectCareer } from "@/models/ProjectCareer";


export const CareerProjectMapper = {

    toDomain: (data:any): ProjectCareer => {
        return {
            projectId: data.projectId,
            careerId: data.careerId
        };
    },

    toPersistence: (projectCareer: ProjectCareer): CreateProjectCareerVariables => {
        return {
            projectId: projectCareer.projectId,
            careerId: projectCareer.careerId
        }
    }
}