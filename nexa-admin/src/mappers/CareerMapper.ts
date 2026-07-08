import type { Career_Key as FirebaseCareer, GetCareersData, GetProjectCareersData } from "@/dataconnect-generated";
import type { Career } from "@/models/Careers";

type FirebaseCareerItem = GetCareersData['careers'][0];

export const mapFirebaseCareer = (firebaseCareer: FirebaseCareerItem): Career => {
    return {
        id: firebaseCareer.id,
        name: firebaseCareer.name,
        departmentId: firebaseCareer.department.name ?? ""
    };
};

export const mapFirebaseCareerList = (firebaseCareers: GetCareersData['careers']): Career[] => {
    if (!firebaseCareers) return [];
    return firebaseCareers.map(mapFirebaseCareer)
}

export const mapProjectCareerList = (
    firebaseCareers: GetProjectCareersData['projectCareers']
): Career[] => {
    if (!firebaseCareers) return [];

    return firebaseCareers.map(pc => ({
        id: pc.career.id,
        name: pc.career.name
    }));
}