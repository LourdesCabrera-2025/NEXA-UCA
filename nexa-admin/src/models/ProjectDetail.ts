export interface ProjectDetail {
    name: string;
    description: string;

    projectType: {
        id: string;
        name: string;
    };

    supervisor: {
        id: string;
        fullName: string;
    };

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