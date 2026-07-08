import { createProject, createProjectCareer, getCareers, getProjectById, getProjects, getProjectType } from '@/dataconnect-generated';
import { mapFirebaseCareerList } from '@/mappers/CareerMapper';
import { mapFirebaseProgramTypeList } from '@/mappers/typeProgramMapper';
import type { Career } from '@/models/Careers';
import type { projectType } from '@/models/typeProgram';
import type { Project } from '@/models/Program';
import { ProgramMapper } from '@/mappers/ProgramMapper';
import { dataConnect } from '@/services/firebase/firebase';
import type { ProjectDetail } from '@/models/ProjectDetail';


export const ProgramService = {
async getProjectById(
    projectId: string
): Promise<ProjectDetail> {

    try {

        const response = await getProjectById(dataConnect, {
            id: projectId
        });

        if (!response.data.project) {
            throw new Error("Proyecto no encontrado.");
        }

        return ProgramMapper.fromGetProjectById(response.data.project);

    } catch (error) {

        console.error("Error al obtener el proyecto:", error);
        throw error;

    }
},

    getAllProjects: async () => {
        const result = await getProjects();

        return result.data.projects;
    },


    createProgram: async (project: Project) => {

        try {
            const data = ProgramMapper.toPersistance(project);

            const result = await createProject(dataConnect, data);

            return result.data.project_insert.id;
        } catch (error) {
            console.error("Error al registrar el proyecto en firebase: ", error);
            throw error;
        }
    },

    createProgramWithCareers: async (project: Project, careers: Career[]) => {
        try {
            const newProjectId = await ProgramService.createProgram(project);
            await Promise.all(
                careers.map(career =>
                    createProjectCareer(dataConnect, {
                        projectId: newProjectId,
                        careerId: career.id
                    })
                )
            );

            return { success: true, projectId: newProjectId };
        } catch (error) {
            console.error("Error al registrar el programa completo", error);
            throw error;
        }


    },


    async getAllCareers(): Promise<Career[]> {

        try {
            const response = await getCareers();

            const rawCareersList = response.data.careers || [];
            return mapFirebaseCareerList(rawCareersList);
        } catch (error) {
            console.error("Error crítico al obtener todas las carreras:", error);
            throw error;
        }
    },

    async getAllProgramsType(): Promise<projectType[]> {
        try {
            const response = await getProjectType();
            const rawProgramTypeList = response.data.projectTypes || [];

            return mapFirebaseProgramTypeList(rawProgramTypeList);
        } catch (error) {
            console.error("Error al obtener los tipos de proyecto", error);
            return [];
        }
    }
}