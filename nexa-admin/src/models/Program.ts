export interface Project {
    projectTypeId: string;
    supervisorId: string;
    name: string;
    description: string;
    startDate: Date;
    endDate: Date;
    latitude: number;
    longitude: number;
    allowedRadius: number;
    maxStudents: number; 
    maxHoursPerDay: number;
    totalRequiredHours: number;
    isActive: boolean;
}