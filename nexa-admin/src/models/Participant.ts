import type { Student } from "./Student";

export interface Participant {
    id: string;

    status: string;
    accumulateHours: number;
  

    student: Student;
}