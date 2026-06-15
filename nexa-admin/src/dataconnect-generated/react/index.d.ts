import { GetMyStudentData, GetUserByIdData, GetUserByIdVariables, CreateUserData, CreateUserVariables, CreateStudentData, CreateStudentVariables, GetCareersData, GetDepartmentData, GetRoleByNameData, GetRoleByNameVariables, GetRolesData } from '../';
import { UseDataConnectQueryResult, useDataConnectQueryOptions, UseDataConnectMutationResult, useDataConnectMutationOptions} from '@tanstack-query-firebase/react/data-connect';
import { UseQueryResult, UseMutationResult} from '@tanstack/react-query';
import { DataConnect } from 'firebase/data-connect';
import { FirebaseError } from 'firebase/app';


export function useGetMyStudent(options?: useDataConnectQueryOptions<GetMyStudentData>): UseDataConnectQueryResult<GetMyStudentData, undefined>;
export function useGetMyStudent(dc: DataConnect, options?: useDataConnectQueryOptions<GetMyStudentData>): UseDataConnectQueryResult<GetMyStudentData, undefined>;

export function useGetUserById(vars: GetUserByIdVariables, options?: useDataConnectQueryOptions<GetUserByIdData>): UseDataConnectQueryResult<GetUserByIdData, GetUserByIdVariables>;
export function useGetUserById(dc: DataConnect, vars: GetUserByIdVariables, options?: useDataConnectQueryOptions<GetUserByIdData>): UseDataConnectQueryResult<GetUserByIdData, GetUserByIdVariables>;

export function useCreateUser(options?: useDataConnectMutationOptions<CreateUserData, FirebaseError, CreateUserVariables>): UseDataConnectMutationResult<CreateUserData, CreateUserVariables>;
export function useCreateUser(dc: DataConnect, options?: useDataConnectMutationOptions<CreateUserData, FirebaseError, CreateUserVariables>): UseDataConnectMutationResult<CreateUserData, CreateUserVariables>;

export function useCreateStudent(options?: useDataConnectMutationOptions<CreateStudentData, FirebaseError, CreateStudentVariables>): UseDataConnectMutationResult<CreateStudentData, CreateStudentVariables>;
export function useCreateStudent(dc: DataConnect, options?: useDataConnectMutationOptions<CreateStudentData, FirebaseError, CreateStudentVariables>): UseDataConnectMutationResult<CreateStudentData, CreateStudentVariables>;

export function useGetCareers(options?: useDataConnectQueryOptions<GetCareersData>): UseDataConnectQueryResult<GetCareersData, undefined>;
export function useGetCareers(dc: DataConnect, options?: useDataConnectQueryOptions<GetCareersData>): UseDataConnectQueryResult<GetCareersData, undefined>;

export function useGetDepartment(options?: useDataConnectQueryOptions<GetDepartmentData>): UseDataConnectQueryResult<GetDepartmentData, undefined>;
export function useGetDepartment(dc: DataConnect, options?: useDataConnectQueryOptions<GetDepartmentData>): UseDataConnectQueryResult<GetDepartmentData, undefined>;

export function useGetRoleByName(vars: GetRoleByNameVariables, options?: useDataConnectQueryOptions<GetRoleByNameData>): UseDataConnectQueryResult<GetRoleByNameData, GetRoleByNameVariables>;
export function useGetRoleByName(dc: DataConnect, vars: GetRoleByNameVariables, options?: useDataConnectQueryOptions<GetRoleByNameData>): UseDataConnectQueryResult<GetRoleByNameData, GetRoleByNameVariables>;

export function useGetRoles(options?: useDataConnectQueryOptions<GetRolesData>): UseDataConnectQueryResult<GetRolesData, undefined>;
export function useGetRoles(dc: DataConnect, options?: useDataConnectQueryOptions<GetRolesData>): UseDataConnectQueryResult<GetRolesData, undefined>;
