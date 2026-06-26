import {getCareers} from '@/dataconnect-generated';
import { mapFirebaseCareerList } from '@/mappers/CareerMapper';
import type { Career } from '@/models/Careers';

export const ProgramService = {
    

    async getAllCareers() : Promise<Career[]> {

        try {
            const response = await getCareers();

            const rawCareersList = response.data.careers || [];
            return mapFirebaseCareerList(rawCareersList);
        } catch (error) {
            console.error("Error crítico al obtener todas las carreras:", error);
            throw error;
        }
    }

}