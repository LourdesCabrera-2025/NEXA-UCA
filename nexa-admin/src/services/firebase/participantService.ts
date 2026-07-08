import { getParticipantsByProject } from "@/dataconnect-generated";
import type { Participant } from "@/models/Participant";
import { dataConnect } from "./firebase";
import { mapFirebaseParticipantList } from "@/mappers/ParticipantMapper";

export const ParticipantService = {

    async getParticipantsByProject(
        projectId: string
    ): Promise<Participant[]> {

        try {
            const response = await getParticipantsByProject(dataConnect, {
                projectId
            });

            const rawParticipants = response.data.participants || [];

            return mapFirebaseParticipantList(rawParticipants);
        }catch(error) {
            console.error(
                "Error al obtener los participantes del proyecto",
                error
            );

            throw error
        }
    }
}