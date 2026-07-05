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

export interface Student_Key {
  id: UUIDString;
  __typename?: 'Student_Key';
}

export interface User_Key {
  id: string;
  __typename?: 'User_Key';
}

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

