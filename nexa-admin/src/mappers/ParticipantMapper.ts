import type { GetParticipantsByProjectData } from "@/dataconnect-generated";
import type { Participant } from "@/models/Participant";


type FirebaseParticipant = GetParticipantsByProjectData['participants'][0];

export const mapFirebaseParticipant = (
    participant: FirebaseParticipant
): Participant => {

    return {
        id: participant.id,
        status: participant.status,
        accumulateHours: Number(participant.accumulateHours),

        student: {
            studentCode: participant.student.studentCode,
            career: participant.student.career
                ? {
                    id: participant.student.career.id,
                    name: participant.student.career.name
                }
                : undefined,
            
            user: {
                fullName: participant.student.user.fullName,
                email: participant.student.user.email,
                photoUrl: participant.student.user.photoUrl ?? undefined
            }
        }
    };
};

export const mapFirebaseParticipantList = (
    participants: GetParticipantsByProjectData['participants']
): Participant[] => {

    if(!participants) return [];

    return participants.map(mapFirebaseParticipant);
}