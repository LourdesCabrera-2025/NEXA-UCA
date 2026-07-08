import { ConnectorConfig, DataConnect, QueryRef, QueryPromise, ExecuteQueryOptions, MutationRef, MutationPromise, DataConnectSettings } from 'firebase/data-connect';

export const connectorConfig: ConnectorConfig;
export const dataConnectSettings: DataConnectSettings;

export type TimestampString = string;
export type UUIDString = string;
export type Int64String = string;
export type DateString = string;




export interface Activity_Key {
  id: UUIDString;
  __typename?: 'Activity_Key';
}

export interface Attendance_Key {
  id: UUIDString;
  __typename?: 'Attendance_Key';
}

export interface Career_Key {
  id: UUIDString;
  __typename?: 'Career_Key';
}

export interface CreateProjectCareerData {
  projectCareer_insert: ProjectCareer_Key;
}

export interface CreateProjectCareerVariables {
  projectId: UUIDString;
  careerId: UUIDString;
}

export interface CreateProjectData {
  project_insert: Project_Key;
}

export interface CreateProjectScheduleData {
  projectSchedule_insert: ProjectSchedule_Key;
}

export interface CreateProjectScheduleVariables {
  participantId: UUIDString;
  dayOfWeek: number;
  startHour: string;
  endHour: string;
}

export interface CreateProjectVariables {
  name: string;
  description: string;
  projectTypeId: UUIDString;
  supervisorId: string;
  startDate: DateString;
  endDate: DateString;
  latitude: number;
  longitude: number;
  allowedRadius: number;
  maxStudents: number;
  totalRequiredHours: number;
  isActive: boolean;
}

export interface CreateStudentData {
  student_insert: Student_Key;
}

export interface CreateStudentVariables {
  studentCode: string;
  phoneNumber: string;
  birthDate?: DateString | null;
  userId: string;
  careerId?: UUIDString | null;
}

export interface CreateUserData {
  user_insert: User_Key;
}

export interface CreateUserVariables {
  id: string;
  email: string;
  fullName: string;
  photoUrl: string;
  roleId: UUIDString;
}

export interface DeleteProjectScheduleData {
  projectSchedule_delete?: ProjectSchedule_Key | null;
}

export interface DeleteProjectScheduleVariables {
  id: UUIDString;
}

export interface Department_Key {
  id: UUIDString;
  __typename?: 'Department_Key';
}

export interface GetCareersData {
  careers: ({
    id: UUIDString;
    name: string;
    department: {
      name: string;
    };
  } & Career_Key)[];
}

export interface GetDepartmentData {
  departments: ({
    id: UUIDString;
    name: string;
  } & Department_Key)[];
}

export interface GetMyStudentData {
  students: ({
    id: UUIDString;
    studentCode: string;
    phoneNumber?: string | null;
    user: {
      id: string;
      email: string;
      fullName: string;
      photoUrl?: string | null;
      isActive: boolean;
      role: {
        id: UUIDString;
        name: string;
      } & Role_Key;
    } & User_Key;
      career?: {
        id: UUIDString;
        name: string;
        department: {
          id: UUIDString;
          name: string;
        } & Department_Key;
      } & Career_Key;
  } & Student_Key)[];
}

export interface GetParticipantsByProjectData {
  participants: ({
    id: UUIDString;
    status: string;
    accumulateHours: number;
    student: {
      studentCode: string;
      career?: {
        id: UUIDString;
        name: string;
      } & Career_Key;
        user: {
          fullName: string;
          email: string;
          photoUrl?: string | null;
        };
    };
  } & Participant_Key)[];
}

export interface GetParticipantsByProjectVariables {
  projectId: UUIDString;
}

export interface GetProjectByIdData {
  project?: {
    id: UUIDString;
    name: string;
    description?: string | null;
    projectType: {
      id: UUIDString;
      name: string;
    } & ProjectType_Key;
      supervisor: {
        id: string;
        fullName: string;
        email: string;
        photoUrl?: string | null;
      } & User_Key;
        startDate: DateString;
        endDate: DateString;
        latitude: number;
        longitude: number;
        allowedRadius: number;
        maxStudents: number;
        maxHoursPerDay: number;
        totalRequiredHours: number;
        isActive: boolean;
        createdAt: DateString;
  } & Project_Key;
}

export interface GetProjectByIdVariables {
  id: UUIDString;
}

export interface GetProjectCareersData {
  projectCareers: ({
    career: {
      id: UUIDString;
      name: string;
    } & Career_Key;
  })[];
}

export interface GetProjectCareersVariables {
  projectId: UUIDString;
}

export interface GetProjectScheduleByParticipantData {
  projectSchedules: ({
    id: UUIDString;
    dayOfWeek: number;
    startHour: string;
    endHour: string;
  } & ProjectSchedule_Key)[];
}

export interface GetProjectScheduleByParticipantVariables {
  participantId: UUIDString;
}

export interface GetProjectSchedulesData {
  projectSchedules: ({
    id: UUIDString;
    dayOfWeek: number;
    startHour: string;
    endHour: string;
    participant: {
      id: UUIDString;
      student: {
        studentCode: string;
        user: {
          id: string;
          fullName: string;
          email: string;
        } & User_Key;
      };
        project: {
          id: UUIDString;
          name: string;
        } & Project_Key;
    } & Participant_Key;
  } & ProjectSchedule_Key)[];
}

export interface GetProjectTypeData {
  projectTypes: ({
    id: UUIDString;
    name: string;
  } & ProjectType_Key)[];
}

export interface GetProjectsData {
  projects: ({
    id: UUIDString;
    name: string;
    description?: string | null;
    projectType: {
      id: UUIDString;
      name: string;
    } & ProjectType_Key;
      supervisor: {
        id: string;
        fullName: string;
      } & User_Key;
        startDate: DateString;
        endDate: DateString;
        latitude: number;
        longitude: number;
        allowedRadius: number;
        maxStudents: number;
        maxHoursPerDay: number;
        totalRequiredHours: number;
        isActive: boolean;
        createdAt: DateString;
  } & Project_Key)[];
}

export interface GetRoleByNameData {
  roles: ({
    id: UUIDString;
    name: string;
  } & Role_Key)[];
}

export interface GetRoleByNameVariables {
  name: string;
}

export interface GetRolesData {
  roles: ({
    id: UUIDString;
    name: string;
  } & Role_Key)[];
}

export interface GetUserByIdData {
  users: ({
    id: string;
    email: string;
    fullName: string;
    photoUrl?: string | null;
    isActive: boolean;
    role: {
      id: UUIDString;
      name: string;
    } & Role_Key;
  } & User_Key)[];
}

export interface GetUserByIdVariables {
  id: string;
}

export interface Participant_Key {
  id: UUIDString;
  __typename?: 'Participant_Key';
}

export interface ProjectCareer_Key {
  projectId: UUIDString;
  careerId: UUIDString;
  __typename?: 'ProjectCareer_Key';
}

export interface ProjectSchedule_Key {
  id: UUIDString;
  __typename?: 'ProjectSchedule_Key';
}

export interface ProjectType_Key {
  id: UUIDString;
  __typename?: 'ProjectType_Key';
}

export interface Project_Key {
  id: UUIDString;
  __typename?: 'Project_Key';
}

export interface Role_Key {
  id: UUIDString;
  __typename?: 'Role_Key';
}

export interface SeedParticipantsData {
  participante1: Participant_Key;
}

export interface SeedProjectScheduleData {
  marteManana: ProjectSchedule_Key;
  martesTarde: ProjectSchedule_Key;
  Miercoles: ProjectSchedule_Key;
}

export interface SeedProjectTypeData {
  servicio_interno: ProjectType_Key;
  servicio_externo: ProjectType_Key;
}

export interface Student_Key {
  id: UUIDString;
  __typename?: 'Student_Key';
}

export interface UpdateProjectScheduleData {
  projectSchedule_update?: ProjectSchedule_Key | null;
}

export interface UpdateProjectScheduleVariables {
  id: UUIDString;
  dayOfWeek: number;
  startHour: string;
  endHour: string;
}

export interface User_Key {
  id: string;
  __typename?: 'User_Key';
}

interface CreateProjectScheduleRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectScheduleVariables): MutationRef<CreateProjectScheduleData, CreateProjectScheduleVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: CreateProjectScheduleVariables): MutationRef<CreateProjectScheduleData, CreateProjectScheduleVariables>;
  operationName: string;
}
export const createProjectScheduleRef: CreateProjectScheduleRef;

export function createProjectSchedule(vars: CreateProjectScheduleVariables): MutationPromise<CreateProjectScheduleData, CreateProjectScheduleVariables>;
export function createProjectSchedule(dc: DataConnect, vars: CreateProjectScheduleVariables): MutationPromise<CreateProjectScheduleData, CreateProjectScheduleVariables>;

interface DeleteProjectScheduleRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: DeleteProjectScheduleVariables): MutationRef<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: DeleteProjectScheduleVariables): MutationRef<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;
  operationName: string;
}
export const deleteProjectScheduleRef: DeleteProjectScheduleRef;

export function deleteProjectSchedule(vars: DeleteProjectScheduleVariables): MutationPromise<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;
export function deleteProjectSchedule(dc: DataConnect, vars: DeleteProjectScheduleVariables): MutationPromise<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;

interface GetCareersRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetCareersData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetCareersData, undefined>;
  operationName: string;
}
export const getCareersRef: GetCareersRef;

export function getCareers(options?: ExecuteQueryOptions): QueryPromise<GetCareersData, undefined>;
export function getCareers(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetCareersData, undefined>;

interface GetDepartmentRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetDepartmentData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetDepartmentData, undefined>;
  operationName: string;
}
export const getDepartmentRef: GetDepartmentRef;

export function getDepartment(options?: ExecuteQueryOptions): QueryPromise<GetDepartmentData, undefined>;
export function getDepartment(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetDepartmentData, undefined>;

interface GetProjectScheduleByParticipantRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectScheduleByParticipantVariables): QueryRef<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetProjectScheduleByParticipantVariables): QueryRef<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;
  operationName: string;
}
export const getProjectScheduleByParticipantRef: GetProjectScheduleByParticipantRef;

export function getProjectScheduleByParticipant(vars: GetProjectScheduleByParticipantVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;
export function getProjectScheduleByParticipant(dc: DataConnect, vars: GetProjectScheduleByParticipantVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;

interface GetProjectTypeRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectTypeData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetProjectTypeData, undefined>;
  operationName: string;
}
export const getProjectTypeRef: GetProjectTypeRef;

export function getProjectType(options?: ExecuteQueryOptions): QueryPromise<GetProjectTypeData, undefined>;
export function getProjectType(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectTypeData, undefined>;

interface GetMyStudentRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetMyStudentData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetMyStudentData, undefined>;
  operationName: string;
}
export const getMyStudentRef: GetMyStudentRef;

export function getMyStudent(options?: ExecuteQueryOptions): QueryPromise<GetMyStudentData, undefined>;
export function getMyStudent(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetMyStudentData, undefined>;

interface CreateProjectRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectVariables): MutationRef<CreateProjectData, CreateProjectVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: CreateProjectVariables): MutationRef<CreateProjectData, CreateProjectVariables>;
  operationName: string;
}
export const createProjectRef: CreateProjectRef;

export function createProject(vars: CreateProjectVariables): MutationPromise<CreateProjectData, CreateProjectVariables>;
export function createProject(dc: DataConnect, vars: CreateProjectVariables): MutationPromise<CreateProjectData, CreateProjectVariables>;

interface GetProjectByIdRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectByIdVariables): QueryRef<GetProjectByIdData, GetProjectByIdVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetProjectByIdVariables): QueryRef<GetProjectByIdData, GetProjectByIdVariables>;
  operationName: string;
}
export const getProjectByIdRef: GetProjectByIdRef;

export function getProjectById(vars: GetProjectByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectByIdData, GetProjectByIdVariables>;
export function getProjectById(dc: DataConnect, vars: GetProjectByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectByIdData, GetProjectByIdVariables>;

interface GetProjectSchedulesRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectSchedulesData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetProjectSchedulesData, undefined>;
  operationName: string;
}
export const getProjectSchedulesRef: GetProjectSchedulesRef;

export function getProjectSchedules(options?: ExecuteQueryOptions): QueryPromise<GetProjectSchedulesData, undefined>;
export function getProjectSchedules(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectSchedulesData, undefined>;

interface GetProjectsRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectsData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetProjectsData, undefined>;
  operationName: string;
}
export const getProjectsRef: GetProjectsRef;

export function getProjects(options?: ExecuteQueryOptions): QueryPromise<GetProjectsData, undefined>;
export function getProjects(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectsData, undefined>;

interface SeedProjectScheduleRef {
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedProjectScheduleData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): MutationRef<SeedProjectScheduleData, undefined>;
  operationName: string;
}
export const seedProjectScheduleRef: SeedProjectScheduleRef;

export function seedProjectSchedule(): MutationPromise<SeedProjectScheduleData, undefined>;
export function seedProjectSchedule(dc: DataConnect): MutationPromise<SeedProjectScheduleData, undefined>;

interface UpdateProjectScheduleRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: UpdateProjectScheduleVariables): MutationRef<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: UpdateProjectScheduleVariables): MutationRef<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;
  operationName: string;
}
export const updateProjectScheduleRef: UpdateProjectScheduleRef;

export function updateProjectSchedule(vars: UpdateProjectScheduleVariables): MutationPromise<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;
export function updateProjectSchedule(dc: DataConnect, vars: UpdateProjectScheduleVariables): MutationPromise<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;

interface GetUserByIdRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetUserByIdVariables): QueryRef<GetUserByIdData, GetUserByIdVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetUserByIdVariables): QueryRef<GetUserByIdData, GetUserByIdVariables>;
  operationName: string;
}
export const getUserByIdRef: GetUserByIdRef;

export function getUserById(vars: GetUserByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetUserByIdData, GetUserByIdVariables>;
export function getUserById(dc: DataConnect, vars: GetUserByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetUserByIdData, GetUserByIdVariables>;

interface CreateUserRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateUserVariables): MutationRef<CreateUserData, CreateUserVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: CreateUserVariables): MutationRef<CreateUserData, CreateUserVariables>;
  operationName: string;
}
export const createUserRef: CreateUserRef;

export function createUser(vars: CreateUserVariables): MutationPromise<CreateUserData, CreateUserVariables>;
export function createUser(dc: DataConnect, vars: CreateUserVariables): MutationPromise<CreateUserData, CreateUserVariables>;

interface CreateStudentRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateStudentVariables): MutationRef<CreateStudentData, CreateStudentVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: CreateStudentVariables): MutationRef<CreateStudentData, CreateStudentVariables>;
  operationName: string;
}
export const createStudentRef: CreateStudentRef;

export function createStudent(vars: CreateStudentVariables): MutationPromise<CreateStudentData, CreateStudentVariables>;
export function createStudent(dc: DataConnect, vars: CreateStudentVariables): MutationPromise<CreateStudentData, CreateStudentVariables>;

interface GetParticipantsByProjectRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetParticipantsByProjectVariables): QueryRef<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetParticipantsByProjectVariables): QueryRef<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;
  operationName: string;
}
export const getParticipantsByProjectRef: GetParticipantsByProjectRef;

export function getParticipantsByProject(vars: GetParticipantsByProjectVariables, options?: ExecuteQueryOptions): QueryPromise<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;
export function getParticipantsByProject(dc: DataConnect, vars: GetParticipantsByProjectVariables, options?: ExecuteQueryOptions): QueryPromise<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;

interface GetRolesRef {
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetRolesData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): QueryRef<GetRolesData, undefined>;
  operationName: string;
}
export const getRolesRef: GetRolesRef;

export function getRoles(options?: ExecuteQueryOptions): QueryPromise<GetRolesData, undefined>;
export function getRoles(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetRolesData, undefined>;

interface SeedParticipantsRef {
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedParticipantsData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): MutationRef<SeedParticipantsData, undefined>;
  operationName: string;
}
export const seedParticipantsRef: SeedParticipantsRef;

export function seedParticipants(): MutationPromise<SeedParticipantsData, undefined>;
export function seedParticipants(dc: DataConnect): MutationPromise<SeedParticipantsData, undefined>;

interface GetProjectCareersRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectCareersVariables): QueryRef<GetProjectCareersData, GetProjectCareersVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetProjectCareersVariables): QueryRef<GetProjectCareersData, GetProjectCareersVariables>;
  operationName: string;
}
export const getProjectCareersRef: GetProjectCareersRef;

export function getProjectCareers(vars: GetProjectCareersVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectCareersData, GetProjectCareersVariables>;
export function getProjectCareers(dc: DataConnect, vars: GetProjectCareersVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectCareersData, GetProjectCareersVariables>;

interface GetRoleByNameRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetRoleByNameVariables): QueryRef<GetRoleByNameData, GetRoleByNameVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: GetRoleByNameVariables): QueryRef<GetRoleByNameData, GetRoleByNameVariables>;
  operationName: string;
}
export const getRoleByNameRef: GetRoleByNameRef;

export function getRoleByName(vars: GetRoleByNameVariables, options?: ExecuteQueryOptions): QueryPromise<GetRoleByNameData, GetRoleByNameVariables>;
export function getRoleByName(dc: DataConnect, vars: GetRoleByNameVariables, options?: ExecuteQueryOptions): QueryPromise<GetRoleByNameData, GetRoleByNameVariables>;

interface CreateProjectCareerRef {
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectCareerVariables): MutationRef<CreateProjectCareerData, CreateProjectCareerVariables>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect, vars: CreateProjectCareerVariables): MutationRef<CreateProjectCareerData, CreateProjectCareerVariables>;
  operationName: string;
}
export const createProjectCareerRef: CreateProjectCareerRef;

export function createProjectCareer(vars: CreateProjectCareerVariables): MutationPromise<CreateProjectCareerData, CreateProjectCareerVariables>;
export function createProjectCareer(dc: DataConnect, vars: CreateProjectCareerVariables): MutationPromise<CreateProjectCareerData, CreateProjectCareerVariables>;

interface SeedProjectTypeRef {
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedProjectTypeData, undefined>;
  /* Allow users to pass in custom DataConnect instances */
  (dc: DataConnect): MutationRef<SeedProjectTypeData, undefined>;
  operationName: string;
}
export const seedProjectTypeRef: SeedProjectTypeRef;

export function seedProjectType(): MutationPromise<SeedProjectTypeData, undefined>;
export function seedProjectType(dc: DataConnect): MutationPromise<SeedProjectTypeData, undefined>;

