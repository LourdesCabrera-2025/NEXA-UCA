import type { Career } from "./Careers";
import type { User } from "./Userproject";

export interface Student {
    studentCode: string;
    career?: Career;
    user: User;
}