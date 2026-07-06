import type { Roles } from "./Roles";

export interface User{
    id: string;
    email: string;
    fullName: string;
    photoUrl?: string;
    isActive: boolean;
    role: Roles;
}