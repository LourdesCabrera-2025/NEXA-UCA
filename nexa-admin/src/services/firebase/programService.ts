import {createProject, getCareers, getProjects, getProjectType} from '@/dataconnect-generated';
import { mapFirebaseCareerList } from '@/mappers/CareerMapper';
import { mapFirebaseProgramTypeList } from '@/mappers/typeProgramMapper';
import type { Career } from '@/models/Careers';
import type { projectType } from '@/models/typeProgram';
import type { Project } from '@/models/Program';
import { ProgramMapper } from '@/mappers/ProgramMapper';
import  { dataConnect } from '@/services/firebase/firebase';
import { executeQuery } from '@firebase/data-connect';

export const ProgramService = {

    getAllProjects: async () => {
        const result = await getProjects();

        return result.data.projects;
    },


    createProgram: async (project: Project) => {

        try {
            const data = ProgramMapper.toPersistance(project);

            const result = await createProject(dataConnect, data);

            return result.data;
        } catch (error) {
            console.error("Error al registrar el proyecto en firebase: ", error);
            throw error;
        }
    },
    

    async getAllCareers() : Promise<Career[]> {

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
        try{
            const response = await getProjectType();
            const rawProgramTypeList = response.data.projectTypes || [];

            return mapFirebaseProgramTypeList(rawProgramTypeList);
        } catch(error) {
            console.error("Error al obtener los tipos de proyecto", error);
            return[];
        }
    }
}