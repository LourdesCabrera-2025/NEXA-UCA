import type {  GetProjectTypeData } from "@/dataconnect-generated";
import type { projectType } from "@/models/typeProgram";

type FirebaseProjectItem = GetProjectTypeData['projectTypes'][0];

export const mapFirebaseProgramType = (firebaseTypeProgram: FirebaseProjectItem) : projectType => {

    return {
        id: firebaseTypeProgram.id,
        name: firebaseTypeProgram.name,
    };
};


export const mapFirebaseProgramTypeList = (firebaseTypePrograms: GetProjectTypeData['projectTypes']) : projectType[] => {
    if(!firebaseTypePrograms)  return [];
    return firebaseTypePrograms.map(mapFirebaseProgramType)
}