# Generated TypeScript README
This README will guide you through the process of using the generated JavaScript SDK package for the connector `nexa`. It will also provide examples on how to use your generated SDK to call your Data Connect queries and mutations.

***NOTE:** This README is generated alongside the generated SDK. If you make changes to this file, they will be overwritten when the SDK is regenerated.*

# Table of Contents
- [**Overview**](#generated-javascript-readme)
- [**Accessing the connector**](#accessing-the-connector)
  - [*Connecting to the local Emulator*](#connecting-to-the-local-emulator)
- [**Queries**](#queries)
  - [*GetDepartment*](#getdepartment)
  - [*GetProjectCareers*](#getprojectcareers)
  - [*GetProjectScheduleByParticipant*](#getprojectschedulebyparticipant)
  - [*GetUserById*](#getuserbyid)
  - [*GetProjectType*](#getprojecttype)
  - [*GetRoles*](#getroles)
  - [*GetMyStudent*](#getmystudent)
  - [*GetCareers*](#getcareers)
  - [*GetParticipantsByProject*](#getparticipantsbyproject)
  - [*GetProjectById*](#getprojectbyid)
  - [*GetRoleByName*](#getrolebyname)
  - [*GetProjectSchedules*](#getprojectschedules)
  - [*GetProjects*](#getprojects)
- [**Mutations**](#mutations)
  - [*CreateProject*](#createproject)
  - [*CreateUser*](#createuser)
  - [*CreateStudent*](#createstudent)
  - [*SeedParticipants*](#seedparticipants)
  - [*CreateProjectCareer*](#createprojectcareer)
  - [*UpdateProjectSchedule*](#updateprojectschedule)
  - [*DeleteProjectSchedule*](#deleteprojectschedule)
  - [*SeedProjectSchedule*](#seedprojectschedule)
  - [*CreateProjectSchedule*](#createprojectschedule)
  - [*SeedProjectType*](#seedprojecttype)

# Accessing the connector
A connector is a collection of Queries and Mutations. One SDK is generated for each connector - this SDK is generated for the connector `nexa`. You can find more information about connectors in the [Data Connect documentation](https://firebase.google.com/docs/data-connect#how-does).

You can use this generated SDK by importing from the package `@dataconnect/generated` as shown below. Both CommonJS and ESM imports are supported.

You can also follow the instructions from the [Data Connect documentation](https://firebase.google.com/docs/data-connect/web-sdk#set-client).

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig } from '@dataconnect/generated';

const dataConnect = getDataConnect(connectorConfig);
```

## Connecting to the local Emulator
By default, the connector will connect to the production service.

To connect to the emulator, you can use the following code.
You can also follow the emulator instructions from the [Data Connect documentation](https://firebase.google.com/docs/data-connect/web-sdk#instrument-clients).

```typescript
import { connectDataConnectEmulator, getDataConnect } from 'firebase/data-connect';
import { connectorConfig } from '@dataconnect/generated';

const dataConnect = getDataConnect(connectorConfig);
connectDataConnectEmulator(dataConnect, 'localhost', 9399);
```

After it's initialized, you can call your Data Connect [queries](#queries) and [mutations](#mutations) from your generated SDK.

# Queries

There are two ways to execute a Data Connect Query using the generated Web SDK:
- Using a Query Reference function, which returns a `QueryRef`
  - The `QueryRef` can be used as an argument to `executeQuery()`, which will execute the Query and return a `QueryPromise`
- Using an action shortcut function, which returns a `QueryPromise`
  - Calling the action shortcut function will execute the Query and return a `QueryPromise`

The following is true for both the action shortcut function and the `QueryRef` function:
- The `QueryPromise` returned will resolve to the result of the Query once it has finished executing
- If the Query accepts arguments, both the action shortcut function and the `QueryRef` function accept a single argument: an object that contains all the required variables (and the optional variables) for the Query
- Both functions can be called with or without passing in a `DataConnect` instance as an argument. If no `DataConnect` argument is passed in, then the generated SDK will call `getDataConnect(connectorConfig)` behind the scenes for you.

Below are examples of how to use the `nexa` connector's generated functions to execute each query. You can also follow the examples from the [Data Connect documentation](https://firebase.google.com/docs/data-connect/web-sdk#using-queries).

## GetDepartment
You can execute the `GetDepartment` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getDepartment(options?: ExecuteQueryOptions): QueryPromise<GetDepartmentData, undefined>;

interface GetDepartmentRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetDepartmentData, undefined>;
}
export const getDepartmentRef: GetDepartmentRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getDepartment(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetDepartmentData, undefined>;

interface GetDepartmentRef {
  ...
  (dc: DataConnect): QueryRef<GetDepartmentData, undefined>;
}
export const getDepartmentRef: GetDepartmentRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getDepartmentRef:
```typescript
const name = getDepartmentRef.operationName;
console.log(name);
```

### Variables
The `GetDepartment` query has no variables.
### Return Type
Recall that executing the `GetDepartment` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetDepartmentData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetDepartmentData {
  departments: ({
    id: UUIDString;
    name: string;
  } & Department_Key)[];
}
```
### Using `GetDepartment`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getDepartment } from '@dataconnect/generated';


// Call the `getDepartment()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getDepartment();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getDepartment(dataConnect);

console.log(data.departments);

// Or, you can use the `Promise` API.
getDepartment().then((response) => {
  const data = response.data;
  console.log(data.departments);
});
```

### Using `GetDepartment`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getDepartmentRef } from '@dataconnect/generated';


// Call the `getDepartmentRef()` function to get a reference to the query.
const ref = getDepartmentRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getDepartmentRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.departments);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.departments);
});
```

## GetProjectCareers
You can execute the `GetProjectCareers` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjectCareers(vars: GetProjectCareersVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectCareersData, GetProjectCareersVariables>;

interface GetProjectCareersRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectCareersVariables): QueryRef<GetProjectCareersData, GetProjectCareersVariables>;
}
export const getProjectCareersRef: GetProjectCareersRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjectCareers(dc: DataConnect, vars: GetProjectCareersVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectCareersData, GetProjectCareersVariables>;

interface GetProjectCareersRef {
  ...
  (dc: DataConnect, vars: GetProjectCareersVariables): QueryRef<GetProjectCareersData, GetProjectCareersVariables>;
}
export const getProjectCareersRef: GetProjectCareersRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectCareersRef:
```typescript
const name = getProjectCareersRef.operationName;
console.log(name);
```

### Variables
The `GetProjectCareers` query requires an argument of type `GetProjectCareersVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetProjectCareersVariables {
  projectId: UUIDString;
}
```
### Return Type
Recall that executing the `GetProjectCareers` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectCareersData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetProjectCareersData {
  projectCareers: ({
    career: {
      id: UUIDString;
      name: string;
    } & Career_Key;
  })[];
}
```
### Using `GetProjectCareers`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjectCareers, GetProjectCareersVariables } from '@dataconnect/generated';

// The `GetProjectCareers` query requires an argument of type `GetProjectCareersVariables`:
const getProjectCareersVars: GetProjectCareersVariables = {
  projectId: ..., 
};

// Call the `getProjectCareers()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjectCareers(getProjectCareersVars);
// Variables can be defined inline as well.
const { data } = await getProjectCareers({ projectId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjectCareers(dataConnect, getProjectCareersVars);

console.log(data.projectCareers);

// Or, you can use the `Promise` API.
getProjectCareers(getProjectCareersVars).then((response) => {
  const data = response.data;
  console.log(data.projectCareers);
});
```

### Using `GetProjectCareers`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectCareersRef, GetProjectCareersVariables } from '@dataconnect/generated';

// The `GetProjectCareers` query requires an argument of type `GetProjectCareersVariables`:
const getProjectCareersVars: GetProjectCareersVariables = {
  projectId: ..., 
};

// Call the `getProjectCareersRef()` function to get a reference to the query.
const ref = getProjectCareersRef(getProjectCareersVars);
// Variables can be defined inline as well.
const ref = getProjectCareersRef({ projectId: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectCareersRef(dataConnect, getProjectCareersVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.projectCareers);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.projectCareers);
});
```

## GetProjectScheduleByParticipant
You can execute the `GetProjectScheduleByParticipant` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjectScheduleByParticipant(vars: GetProjectScheduleByParticipantVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;

interface GetProjectScheduleByParticipantRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectScheduleByParticipantVariables): QueryRef<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;
}
export const getProjectScheduleByParticipantRef: GetProjectScheduleByParticipantRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjectScheduleByParticipant(dc: DataConnect, vars: GetProjectScheduleByParticipantVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;

interface GetProjectScheduleByParticipantRef {
  ...
  (dc: DataConnect, vars: GetProjectScheduleByParticipantVariables): QueryRef<GetProjectScheduleByParticipantData, GetProjectScheduleByParticipantVariables>;
}
export const getProjectScheduleByParticipantRef: GetProjectScheduleByParticipantRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectScheduleByParticipantRef:
```typescript
const name = getProjectScheduleByParticipantRef.operationName;
console.log(name);
```

### Variables
The `GetProjectScheduleByParticipant` query requires an argument of type `GetProjectScheduleByParticipantVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetProjectScheduleByParticipantVariables {
  participantId: UUIDString;
}
```
### Return Type
Recall that executing the `GetProjectScheduleByParticipant` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectScheduleByParticipantData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetProjectScheduleByParticipantData {
  projectSchedules: ({
    id: UUIDString;
    dayOfWeek: number;
    startHour: string;
    endHour: string;
  } & ProjectSchedule_Key)[];
}
```
### Using `GetProjectScheduleByParticipant`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjectScheduleByParticipant, GetProjectScheduleByParticipantVariables } from '@dataconnect/generated';

// The `GetProjectScheduleByParticipant` query requires an argument of type `GetProjectScheduleByParticipantVariables`:
const getProjectScheduleByParticipantVars: GetProjectScheduleByParticipantVariables = {
  participantId: ..., 
};

// Call the `getProjectScheduleByParticipant()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjectScheduleByParticipant(getProjectScheduleByParticipantVars);
// Variables can be defined inline as well.
const { data } = await getProjectScheduleByParticipant({ participantId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjectScheduleByParticipant(dataConnect, getProjectScheduleByParticipantVars);

console.log(data.projectSchedules);

// Or, you can use the `Promise` API.
getProjectScheduleByParticipant(getProjectScheduleByParticipantVars).then((response) => {
  const data = response.data;
  console.log(data.projectSchedules);
});
```

### Using `GetProjectScheduleByParticipant`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectScheduleByParticipantRef, GetProjectScheduleByParticipantVariables } from '@dataconnect/generated';

// The `GetProjectScheduleByParticipant` query requires an argument of type `GetProjectScheduleByParticipantVariables`:
const getProjectScheduleByParticipantVars: GetProjectScheduleByParticipantVariables = {
  participantId: ..., 
};

// Call the `getProjectScheduleByParticipantRef()` function to get a reference to the query.
const ref = getProjectScheduleByParticipantRef(getProjectScheduleByParticipantVars);
// Variables can be defined inline as well.
const ref = getProjectScheduleByParticipantRef({ participantId: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectScheduleByParticipantRef(dataConnect, getProjectScheduleByParticipantVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.projectSchedules);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.projectSchedules);
});
```

## GetUserById
You can execute the `GetUserById` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getUserById(vars: GetUserByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetUserByIdData, GetUserByIdVariables>;

interface GetUserByIdRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetUserByIdVariables): QueryRef<GetUserByIdData, GetUserByIdVariables>;
}
export const getUserByIdRef: GetUserByIdRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getUserById(dc: DataConnect, vars: GetUserByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetUserByIdData, GetUserByIdVariables>;

interface GetUserByIdRef {
  ...
  (dc: DataConnect, vars: GetUserByIdVariables): QueryRef<GetUserByIdData, GetUserByIdVariables>;
}
export const getUserByIdRef: GetUserByIdRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getUserByIdRef:
```typescript
const name = getUserByIdRef.operationName;
console.log(name);
```

### Variables
The `GetUserById` query requires an argument of type `GetUserByIdVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetUserByIdVariables {
  id: string;
}
```
### Return Type
Recall that executing the `GetUserById` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetUserByIdData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetUserById`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getUserById, GetUserByIdVariables } from '@dataconnect/generated';

// The `GetUserById` query requires an argument of type `GetUserByIdVariables`:
const getUserByIdVars: GetUserByIdVariables = {
  id: ..., 
};

// Call the `getUserById()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getUserById(getUserByIdVars);
// Variables can be defined inline as well.
const { data } = await getUserById({ id: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getUserById(dataConnect, getUserByIdVars);

console.log(data.users);

// Or, you can use the `Promise` API.
getUserById(getUserByIdVars).then((response) => {
  const data = response.data;
  console.log(data.users);
});
```

### Using `GetUserById`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getUserByIdRef, GetUserByIdVariables } from '@dataconnect/generated';

// The `GetUserById` query requires an argument of type `GetUserByIdVariables`:
const getUserByIdVars: GetUserByIdVariables = {
  id: ..., 
};

// Call the `getUserByIdRef()` function to get a reference to the query.
const ref = getUserByIdRef(getUserByIdVars);
// Variables can be defined inline as well.
const ref = getUserByIdRef({ id: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getUserByIdRef(dataConnect, getUserByIdVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.users);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.users);
});
```

## GetProjectType
You can execute the `GetProjectType` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjectType(options?: ExecuteQueryOptions): QueryPromise<GetProjectTypeData, undefined>;

interface GetProjectTypeRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectTypeData, undefined>;
}
export const getProjectTypeRef: GetProjectTypeRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjectType(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectTypeData, undefined>;

interface GetProjectTypeRef {
  ...
  (dc: DataConnect): QueryRef<GetProjectTypeData, undefined>;
}
export const getProjectTypeRef: GetProjectTypeRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectTypeRef:
```typescript
const name = getProjectTypeRef.operationName;
console.log(name);
```

### Variables
The `GetProjectType` query has no variables.
### Return Type
Recall that executing the `GetProjectType` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectTypeData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetProjectTypeData {
  projectTypes: ({
    id: UUIDString;
    name: string;
  } & ProjectType_Key)[];
}
```
### Using `GetProjectType`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjectType } from '@dataconnect/generated';


// Call the `getProjectType()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjectType();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjectType(dataConnect);

console.log(data.projectTypes);

// Or, you can use the `Promise` API.
getProjectType().then((response) => {
  const data = response.data;
  console.log(data.projectTypes);
});
```

### Using `GetProjectType`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectTypeRef } from '@dataconnect/generated';


// Call the `getProjectTypeRef()` function to get a reference to the query.
const ref = getProjectTypeRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectTypeRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.projectTypes);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.projectTypes);
});
```

## GetRoles
You can execute the `GetRoles` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getRoles(options?: ExecuteQueryOptions): QueryPromise<GetRolesData, undefined>;

interface GetRolesRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetRolesData, undefined>;
}
export const getRolesRef: GetRolesRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getRoles(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetRolesData, undefined>;

interface GetRolesRef {
  ...
  (dc: DataConnect): QueryRef<GetRolesData, undefined>;
}
export const getRolesRef: GetRolesRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getRolesRef:
```typescript
const name = getRolesRef.operationName;
console.log(name);
```

### Variables
The `GetRoles` query has no variables.
### Return Type
Recall that executing the `GetRoles` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetRolesData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetRolesData {
  roles: ({
    id: UUIDString;
    name: string;
  } & Role_Key)[];
}
```
### Using `GetRoles`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getRoles } from '@dataconnect/generated';


// Call the `getRoles()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getRoles();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getRoles(dataConnect);

console.log(data.roles);

// Or, you can use the `Promise` API.
getRoles().then((response) => {
  const data = response.data;
  console.log(data.roles);
});
```

### Using `GetRoles`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getRolesRef } from '@dataconnect/generated';


// Call the `getRolesRef()` function to get a reference to the query.
const ref = getRolesRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getRolesRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.roles);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.roles);
});
```

## GetMyStudent
You can execute the `GetMyStudent` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getMyStudent(options?: ExecuteQueryOptions): QueryPromise<GetMyStudentData, undefined>;

interface GetMyStudentRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetMyStudentData, undefined>;
}
export const getMyStudentRef: GetMyStudentRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getMyStudent(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetMyStudentData, undefined>;

interface GetMyStudentRef {
  ...
  (dc: DataConnect): QueryRef<GetMyStudentData, undefined>;
}
export const getMyStudentRef: GetMyStudentRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getMyStudentRef:
```typescript
const name = getMyStudentRef.operationName;
console.log(name);
```

### Variables
The `GetMyStudent` query has no variables.
### Return Type
Recall that executing the `GetMyStudent` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetMyStudentData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetMyStudent`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getMyStudent } from '@dataconnect/generated';


// Call the `getMyStudent()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getMyStudent();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getMyStudent(dataConnect);

console.log(data.students);

// Or, you can use the `Promise` API.
getMyStudent().then((response) => {
  const data = response.data;
  console.log(data.students);
});
```

### Using `GetMyStudent`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getMyStudentRef } from '@dataconnect/generated';


// Call the `getMyStudentRef()` function to get a reference to the query.
const ref = getMyStudentRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getMyStudentRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.students);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.students);
});
```

## GetCareers
You can execute the `GetCareers` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getCareers(options?: ExecuteQueryOptions): QueryPromise<GetCareersData, undefined>;

interface GetCareersRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetCareersData, undefined>;
}
export const getCareersRef: GetCareersRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getCareers(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetCareersData, undefined>;

interface GetCareersRef {
  ...
  (dc: DataConnect): QueryRef<GetCareersData, undefined>;
}
export const getCareersRef: GetCareersRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getCareersRef:
```typescript
const name = getCareersRef.operationName;
console.log(name);
```

### Variables
The `GetCareers` query has no variables.
### Return Type
Recall that executing the `GetCareers` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetCareersData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetCareersData {
  careers: ({
    id: UUIDString;
    name: string;
    department: {
      name: string;
    };
  } & Career_Key)[];
}
```
### Using `GetCareers`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getCareers } from '@dataconnect/generated';


// Call the `getCareers()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getCareers();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getCareers(dataConnect);

console.log(data.careers);

// Or, you can use the `Promise` API.
getCareers().then((response) => {
  const data = response.data;
  console.log(data.careers);
});
```

### Using `GetCareers`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getCareersRef } from '@dataconnect/generated';


// Call the `getCareersRef()` function to get a reference to the query.
const ref = getCareersRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getCareersRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.careers);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.careers);
});
```

## GetParticipantsByProject
You can execute the `GetParticipantsByProject` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getParticipantsByProject(vars: GetParticipantsByProjectVariables, options?: ExecuteQueryOptions): QueryPromise<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;

interface GetParticipantsByProjectRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetParticipantsByProjectVariables): QueryRef<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;
}
export const getParticipantsByProjectRef: GetParticipantsByProjectRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getParticipantsByProject(dc: DataConnect, vars: GetParticipantsByProjectVariables, options?: ExecuteQueryOptions): QueryPromise<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;

interface GetParticipantsByProjectRef {
  ...
  (dc: DataConnect, vars: GetParticipantsByProjectVariables): QueryRef<GetParticipantsByProjectData, GetParticipantsByProjectVariables>;
}
export const getParticipantsByProjectRef: GetParticipantsByProjectRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getParticipantsByProjectRef:
```typescript
const name = getParticipantsByProjectRef.operationName;
console.log(name);
```

### Variables
The `GetParticipantsByProject` query requires an argument of type `GetParticipantsByProjectVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetParticipantsByProjectVariables {
  projectId: UUIDString;
}
```
### Return Type
Recall that executing the `GetParticipantsByProject` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetParticipantsByProjectData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetParticipantsByProject`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getParticipantsByProject, GetParticipantsByProjectVariables } from '@dataconnect/generated';

// The `GetParticipantsByProject` query requires an argument of type `GetParticipantsByProjectVariables`:
const getParticipantsByProjectVars: GetParticipantsByProjectVariables = {
  projectId: ..., 
};

// Call the `getParticipantsByProject()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getParticipantsByProject(getParticipantsByProjectVars);
// Variables can be defined inline as well.
const { data } = await getParticipantsByProject({ projectId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getParticipantsByProject(dataConnect, getParticipantsByProjectVars);

console.log(data.participants);

// Or, you can use the `Promise` API.
getParticipantsByProject(getParticipantsByProjectVars).then((response) => {
  const data = response.data;
  console.log(data.participants);
});
```

### Using `GetParticipantsByProject`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getParticipantsByProjectRef, GetParticipantsByProjectVariables } from '@dataconnect/generated';

// The `GetParticipantsByProject` query requires an argument of type `GetParticipantsByProjectVariables`:
const getParticipantsByProjectVars: GetParticipantsByProjectVariables = {
  projectId: ..., 
};

// Call the `getParticipantsByProjectRef()` function to get a reference to the query.
const ref = getParticipantsByProjectRef(getParticipantsByProjectVars);
// Variables can be defined inline as well.
const ref = getParticipantsByProjectRef({ projectId: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getParticipantsByProjectRef(dataConnect, getParticipantsByProjectVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.participants);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.participants);
});
```

## GetProjectById
You can execute the `GetProjectById` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjectById(vars: GetProjectByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectByIdData, GetProjectByIdVariables>;

interface GetProjectByIdRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetProjectByIdVariables): QueryRef<GetProjectByIdData, GetProjectByIdVariables>;
}
export const getProjectByIdRef: GetProjectByIdRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjectById(dc: DataConnect, vars: GetProjectByIdVariables, options?: ExecuteQueryOptions): QueryPromise<GetProjectByIdData, GetProjectByIdVariables>;

interface GetProjectByIdRef {
  ...
  (dc: DataConnect, vars: GetProjectByIdVariables): QueryRef<GetProjectByIdData, GetProjectByIdVariables>;
}
export const getProjectByIdRef: GetProjectByIdRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectByIdRef:
```typescript
const name = getProjectByIdRef.operationName;
console.log(name);
```

### Variables
The `GetProjectById` query requires an argument of type `GetProjectByIdVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetProjectByIdVariables {
  id: UUIDString;
}
```
### Return Type
Recall that executing the `GetProjectById` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectByIdData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetProjectById`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjectById, GetProjectByIdVariables } from '@dataconnect/generated';

// The `GetProjectById` query requires an argument of type `GetProjectByIdVariables`:
const getProjectByIdVars: GetProjectByIdVariables = {
  id: ..., 
};

// Call the `getProjectById()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjectById(getProjectByIdVars);
// Variables can be defined inline as well.
const { data } = await getProjectById({ id: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjectById(dataConnect, getProjectByIdVars);

console.log(data.project);

// Or, you can use the `Promise` API.
getProjectById(getProjectByIdVars).then((response) => {
  const data = response.data;
  console.log(data.project);
});
```

### Using `GetProjectById`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectByIdRef, GetProjectByIdVariables } from '@dataconnect/generated';

// The `GetProjectById` query requires an argument of type `GetProjectByIdVariables`:
const getProjectByIdVars: GetProjectByIdVariables = {
  id: ..., 
};

// Call the `getProjectByIdRef()` function to get a reference to the query.
const ref = getProjectByIdRef(getProjectByIdVars);
// Variables can be defined inline as well.
const ref = getProjectByIdRef({ id: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectByIdRef(dataConnect, getProjectByIdVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.project);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.project);
});
```

## GetRoleByName
You can execute the `GetRoleByName` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getRoleByName(vars: GetRoleByNameVariables, options?: ExecuteQueryOptions): QueryPromise<GetRoleByNameData, GetRoleByNameVariables>;

interface GetRoleByNameRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: GetRoleByNameVariables): QueryRef<GetRoleByNameData, GetRoleByNameVariables>;
}
export const getRoleByNameRef: GetRoleByNameRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getRoleByName(dc: DataConnect, vars: GetRoleByNameVariables, options?: ExecuteQueryOptions): QueryPromise<GetRoleByNameData, GetRoleByNameVariables>;

interface GetRoleByNameRef {
  ...
  (dc: DataConnect, vars: GetRoleByNameVariables): QueryRef<GetRoleByNameData, GetRoleByNameVariables>;
}
export const getRoleByNameRef: GetRoleByNameRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getRoleByNameRef:
```typescript
const name = getRoleByNameRef.operationName;
console.log(name);
```

### Variables
The `GetRoleByName` query requires an argument of type `GetRoleByNameVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface GetRoleByNameVariables {
  name: string;
}
```
### Return Type
Recall that executing the `GetRoleByName` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetRoleByNameData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface GetRoleByNameData {
  roles: ({
    id: UUIDString;
    name: string;
  } & Role_Key)[];
}
```
### Using `GetRoleByName`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getRoleByName, GetRoleByNameVariables } from '@dataconnect/generated';

// The `GetRoleByName` query requires an argument of type `GetRoleByNameVariables`:
const getRoleByNameVars: GetRoleByNameVariables = {
  name: ..., 
};

// Call the `getRoleByName()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getRoleByName(getRoleByNameVars);
// Variables can be defined inline as well.
const { data } = await getRoleByName({ name: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getRoleByName(dataConnect, getRoleByNameVars);

console.log(data.roles);

// Or, you can use the `Promise` API.
getRoleByName(getRoleByNameVars).then((response) => {
  const data = response.data;
  console.log(data.roles);
});
```

### Using `GetRoleByName`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getRoleByNameRef, GetRoleByNameVariables } from '@dataconnect/generated';

// The `GetRoleByName` query requires an argument of type `GetRoleByNameVariables`:
const getRoleByNameVars: GetRoleByNameVariables = {
  name: ..., 
};

// Call the `getRoleByNameRef()` function to get a reference to the query.
const ref = getRoleByNameRef(getRoleByNameVars);
// Variables can be defined inline as well.
const ref = getRoleByNameRef({ name: ..., });

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getRoleByNameRef(dataConnect, getRoleByNameVars);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.roles);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.roles);
});
```

## GetProjectSchedules
You can execute the `GetProjectSchedules` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjectSchedules(options?: ExecuteQueryOptions): QueryPromise<GetProjectSchedulesData, undefined>;

interface GetProjectSchedulesRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectSchedulesData, undefined>;
}
export const getProjectSchedulesRef: GetProjectSchedulesRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjectSchedules(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectSchedulesData, undefined>;

interface GetProjectSchedulesRef {
  ...
  (dc: DataConnect): QueryRef<GetProjectSchedulesData, undefined>;
}
export const getProjectSchedulesRef: GetProjectSchedulesRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectSchedulesRef:
```typescript
const name = getProjectSchedulesRef.operationName;
console.log(name);
```

### Variables
The `GetProjectSchedules` query has no variables.
### Return Type
Recall that executing the `GetProjectSchedules` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectSchedulesData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetProjectSchedules`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjectSchedules } from '@dataconnect/generated';


// Call the `getProjectSchedules()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjectSchedules();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjectSchedules(dataConnect);

console.log(data.projectSchedules);

// Or, you can use the `Promise` API.
getProjectSchedules().then((response) => {
  const data = response.data;
  console.log(data.projectSchedules);
});
```

### Using `GetProjectSchedules`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectSchedulesRef } from '@dataconnect/generated';


// Call the `getProjectSchedulesRef()` function to get a reference to the query.
const ref = getProjectSchedulesRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectSchedulesRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.projectSchedules);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.projectSchedules);
});
```

## GetProjects
You can execute the `GetProjects` query using the following action shortcut function, or by calling `executeQuery()` after calling the following `QueryRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
getProjects(options?: ExecuteQueryOptions): QueryPromise<GetProjectsData, undefined>;

interface GetProjectsRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): QueryRef<GetProjectsData, undefined>;
}
export const getProjectsRef: GetProjectsRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `QueryRef` function.
```typescript
getProjects(dc: DataConnect, options?: ExecuteQueryOptions): QueryPromise<GetProjectsData, undefined>;

interface GetProjectsRef {
  ...
  (dc: DataConnect): QueryRef<GetProjectsData, undefined>;
}
export const getProjectsRef: GetProjectsRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the getProjectsRef:
```typescript
const name = getProjectsRef.operationName;
console.log(name);
```

### Variables
The `GetProjects` query has no variables.
### Return Type
Recall that executing the `GetProjects` query returns a `QueryPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `GetProjectsData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
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
```
### Using `GetProjects`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, getProjects } from '@dataconnect/generated';


// Call the `getProjects()` function to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await getProjects();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await getProjects(dataConnect);

console.log(data.projects);

// Or, you can use the `Promise` API.
getProjects().then((response) => {
  const data = response.data;
  console.log(data.projects);
});
```

### Using `GetProjects`'s `QueryRef` function

```typescript
import { getDataConnect, executeQuery } from 'firebase/data-connect';
import { connectorConfig, getProjectsRef } from '@dataconnect/generated';


// Call the `getProjectsRef()` function to get a reference to the query.
const ref = getProjectsRef();

// You can also pass in a `DataConnect` instance to the `QueryRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = getProjectsRef(dataConnect);

// Call `executeQuery()` on the reference to execute the query.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeQuery(ref);

console.log(data.projects);

// Or, you can use the `Promise` API.
executeQuery(ref).then((response) => {
  const data = response.data;
  console.log(data.projects);
});
```

# Mutations

There are two ways to execute a Data Connect Mutation using the generated Web SDK:
- Using a Mutation Reference function, which returns a `MutationRef`
  - The `MutationRef` can be used as an argument to `executeMutation()`, which will execute the Mutation and return a `MutationPromise`
- Using an action shortcut function, which returns a `MutationPromise`
  - Calling the action shortcut function will execute the Mutation and return a `MutationPromise`

The following is true for both the action shortcut function and the `MutationRef` function:
- The `MutationPromise` returned will resolve to the result of the Mutation once it has finished executing
- If the Mutation accepts arguments, both the action shortcut function and the `MutationRef` function accept a single argument: an object that contains all the required variables (and the optional variables) for the Mutation
- Both functions can be called with or without passing in a `DataConnect` instance as an argument. If no `DataConnect` argument is passed in, then the generated SDK will call `getDataConnect(connectorConfig)` behind the scenes for you.

Below are examples of how to use the `nexa` connector's generated functions to execute each mutation. You can also follow the examples from the [Data Connect documentation](https://firebase.google.com/docs/data-connect/web-sdk#using-mutations).

## CreateProject
You can execute the `CreateProject` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
createProject(vars: CreateProjectVariables): MutationPromise<CreateProjectData, CreateProjectVariables>;

interface CreateProjectRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectVariables): MutationRef<CreateProjectData, CreateProjectVariables>;
}
export const createProjectRef: CreateProjectRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
createProject(dc: DataConnect, vars: CreateProjectVariables): MutationPromise<CreateProjectData, CreateProjectVariables>;

interface CreateProjectRef {
  ...
  (dc: DataConnect, vars: CreateProjectVariables): MutationRef<CreateProjectData, CreateProjectVariables>;
}
export const createProjectRef: CreateProjectRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the createProjectRef:
```typescript
const name = createProjectRef.operationName;
console.log(name);
```

### Variables
The `CreateProject` mutation requires an argument of type `CreateProjectVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
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
```
### Return Type
Recall that executing the `CreateProject` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `CreateProjectData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface CreateProjectData {
  project_insert: Project_Key;
}
```
### Using `CreateProject`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, createProject, CreateProjectVariables } from '@dataconnect/generated';

// The `CreateProject` mutation requires an argument of type `CreateProjectVariables`:
const createProjectVars: CreateProjectVariables = {
  name: ..., 
  description: ..., 
  projectTypeId: ..., 
  supervisorId: ..., 
  startDate: ..., 
  endDate: ..., 
  latitude: ..., 
  longitude: ..., 
  allowedRadius: ..., 
  maxStudents: ..., 
  totalRequiredHours: ..., 
  isActive: ..., 
};

// Call the `createProject()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await createProject(createProjectVars);
// Variables can be defined inline as well.
const { data } = await createProject({ name: ..., description: ..., projectTypeId: ..., supervisorId: ..., startDate: ..., endDate: ..., latitude: ..., longitude: ..., allowedRadius: ..., maxStudents: ..., totalRequiredHours: ..., isActive: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await createProject(dataConnect, createProjectVars);

console.log(data.project_insert);

// Or, you can use the `Promise` API.
createProject(createProjectVars).then((response) => {
  const data = response.data;
  console.log(data.project_insert);
});
```

### Using `CreateProject`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, createProjectRef, CreateProjectVariables } from '@dataconnect/generated';

// The `CreateProject` mutation requires an argument of type `CreateProjectVariables`:
const createProjectVars: CreateProjectVariables = {
  name: ..., 
  description: ..., 
  projectTypeId: ..., 
  supervisorId: ..., 
  startDate: ..., 
  endDate: ..., 
  latitude: ..., 
  longitude: ..., 
  allowedRadius: ..., 
  maxStudents: ..., 
  totalRequiredHours: ..., 
  isActive: ..., 
};

// Call the `createProjectRef()` function to get a reference to the mutation.
const ref = createProjectRef(createProjectVars);
// Variables can be defined inline as well.
const ref = createProjectRef({ name: ..., description: ..., projectTypeId: ..., supervisorId: ..., startDate: ..., endDate: ..., latitude: ..., longitude: ..., allowedRadius: ..., maxStudents: ..., totalRequiredHours: ..., isActive: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = createProjectRef(dataConnect, createProjectVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.project_insert);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.project_insert);
});
```

## CreateUser
You can execute the `CreateUser` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
createUser(vars: CreateUserVariables): MutationPromise<CreateUserData, CreateUserVariables>;

interface CreateUserRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateUserVariables): MutationRef<CreateUserData, CreateUserVariables>;
}
export const createUserRef: CreateUserRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
createUser(dc: DataConnect, vars: CreateUserVariables): MutationPromise<CreateUserData, CreateUserVariables>;

interface CreateUserRef {
  ...
  (dc: DataConnect, vars: CreateUserVariables): MutationRef<CreateUserData, CreateUserVariables>;
}
export const createUserRef: CreateUserRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the createUserRef:
```typescript
const name = createUserRef.operationName;
console.log(name);
```

### Variables
The `CreateUser` mutation requires an argument of type `CreateUserVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface CreateUserVariables {
  id: string;
  email: string;
  fullName: string;
  photoUrl: string;
  roleId: UUIDString;
}
```
### Return Type
Recall that executing the `CreateUser` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `CreateUserData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface CreateUserData {
  user_insert: User_Key;
}
```
### Using `CreateUser`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, createUser, CreateUserVariables } from '@dataconnect/generated';

// The `CreateUser` mutation requires an argument of type `CreateUserVariables`:
const createUserVars: CreateUserVariables = {
  id: ..., 
  email: ..., 
  fullName: ..., 
  photoUrl: ..., 
  roleId: ..., 
};

// Call the `createUser()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await createUser(createUserVars);
// Variables can be defined inline as well.
const { data } = await createUser({ id: ..., email: ..., fullName: ..., photoUrl: ..., roleId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await createUser(dataConnect, createUserVars);

console.log(data.user_insert);

// Or, you can use the `Promise` API.
createUser(createUserVars).then((response) => {
  const data = response.data;
  console.log(data.user_insert);
});
```

### Using `CreateUser`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, createUserRef, CreateUserVariables } from '@dataconnect/generated';

// The `CreateUser` mutation requires an argument of type `CreateUserVariables`:
const createUserVars: CreateUserVariables = {
  id: ..., 
  email: ..., 
  fullName: ..., 
  photoUrl: ..., 
  roleId: ..., 
};

// Call the `createUserRef()` function to get a reference to the mutation.
const ref = createUserRef(createUserVars);
// Variables can be defined inline as well.
const ref = createUserRef({ id: ..., email: ..., fullName: ..., photoUrl: ..., roleId: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = createUserRef(dataConnect, createUserVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.user_insert);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.user_insert);
});
```

## CreateStudent
You can execute the `CreateStudent` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
createStudent(vars: CreateStudentVariables): MutationPromise<CreateStudentData, CreateStudentVariables>;

interface CreateStudentRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateStudentVariables): MutationRef<CreateStudentData, CreateStudentVariables>;
}
export const createStudentRef: CreateStudentRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
createStudent(dc: DataConnect, vars: CreateStudentVariables): MutationPromise<CreateStudentData, CreateStudentVariables>;

interface CreateStudentRef {
  ...
  (dc: DataConnect, vars: CreateStudentVariables): MutationRef<CreateStudentData, CreateStudentVariables>;
}
export const createStudentRef: CreateStudentRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the createStudentRef:
```typescript
const name = createStudentRef.operationName;
console.log(name);
```

### Variables
The `CreateStudent` mutation requires an argument of type `CreateStudentVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface CreateStudentVariables {
  studentCode: string;
  phoneNumber: string;
  birthDate?: DateString | null;
  userId: string;
  careerId?: UUIDString | null;
}
```
### Return Type
Recall that executing the `CreateStudent` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `CreateStudentData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface CreateStudentData {
  student_insert: Student_Key;
}
```
### Using `CreateStudent`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, createStudent, CreateStudentVariables } from '@dataconnect/generated';

// The `CreateStudent` mutation requires an argument of type `CreateStudentVariables`:
const createStudentVars: CreateStudentVariables = {
  studentCode: ..., 
  phoneNumber: ..., 
  birthDate: ..., // optional
  userId: ..., 
  careerId: ..., // optional
};

// Call the `createStudent()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await createStudent(createStudentVars);
// Variables can be defined inline as well.
const { data } = await createStudent({ studentCode: ..., phoneNumber: ..., birthDate: ..., userId: ..., careerId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await createStudent(dataConnect, createStudentVars);

console.log(data.student_insert);

// Or, you can use the `Promise` API.
createStudent(createStudentVars).then((response) => {
  const data = response.data;
  console.log(data.student_insert);
});
```

### Using `CreateStudent`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, createStudentRef, CreateStudentVariables } from '@dataconnect/generated';

// The `CreateStudent` mutation requires an argument of type `CreateStudentVariables`:
const createStudentVars: CreateStudentVariables = {
  studentCode: ..., 
  phoneNumber: ..., 
  birthDate: ..., // optional
  userId: ..., 
  careerId: ..., // optional
};

// Call the `createStudentRef()` function to get a reference to the mutation.
const ref = createStudentRef(createStudentVars);
// Variables can be defined inline as well.
const ref = createStudentRef({ studentCode: ..., phoneNumber: ..., birthDate: ..., userId: ..., careerId: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = createStudentRef(dataConnect, createStudentVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.student_insert);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.student_insert);
});
```

## SeedParticipants
You can execute the `SeedParticipants` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
seedParticipants(): MutationPromise<SeedParticipantsData, undefined>;

interface SeedParticipantsRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedParticipantsData, undefined>;
}
export const seedParticipantsRef: SeedParticipantsRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
seedParticipants(dc: DataConnect): MutationPromise<SeedParticipantsData, undefined>;

interface SeedParticipantsRef {
  ...
  (dc: DataConnect): MutationRef<SeedParticipantsData, undefined>;
}
export const seedParticipantsRef: SeedParticipantsRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the seedParticipantsRef:
```typescript
const name = seedParticipantsRef.operationName;
console.log(name);
```

### Variables
The `SeedParticipants` mutation has no variables.
### Return Type
Recall that executing the `SeedParticipants` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `SeedParticipantsData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface SeedParticipantsData {
  participante1: Participant_Key;
}
```
### Using `SeedParticipants`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, seedParticipants } from '@dataconnect/generated';


// Call the `seedParticipants()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await seedParticipants();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await seedParticipants(dataConnect);

console.log(data.participante1);

// Or, you can use the `Promise` API.
seedParticipants().then((response) => {
  const data = response.data;
  console.log(data.participante1);
});
```

### Using `SeedParticipants`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, seedParticipantsRef } from '@dataconnect/generated';


// Call the `seedParticipantsRef()` function to get a reference to the mutation.
const ref = seedParticipantsRef();

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = seedParticipantsRef(dataConnect);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.participante1);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.participante1);
});
```

## CreateProjectCareer
You can execute the `CreateProjectCareer` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
createProjectCareer(vars: CreateProjectCareerVariables): MutationPromise<CreateProjectCareerData, CreateProjectCareerVariables>;

interface CreateProjectCareerRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectCareerVariables): MutationRef<CreateProjectCareerData, CreateProjectCareerVariables>;
}
export const createProjectCareerRef: CreateProjectCareerRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
createProjectCareer(dc: DataConnect, vars: CreateProjectCareerVariables): MutationPromise<CreateProjectCareerData, CreateProjectCareerVariables>;

interface CreateProjectCareerRef {
  ...
  (dc: DataConnect, vars: CreateProjectCareerVariables): MutationRef<CreateProjectCareerData, CreateProjectCareerVariables>;
}
export const createProjectCareerRef: CreateProjectCareerRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the createProjectCareerRef:
```typescript
const name = createProjectCareerRef.operationName;
console.log(name);
```

### Variables
The `CreateProjectCareer` mutation requires an argument of type `CreateProjectCareerVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface CreateProjectCareerVariables {
  projectId: UUIDString;
  careerId: UUIDString;
}
```
### Return Type
Recall that executing the `CreateProjectCareer` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `CreateProjectCareerData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface CreateProjectCareerData {
  projectCareer_insert: ProjectCareer_Key;
}
```
### Using `CreateProjectCareer`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, createProjectCareer, CreateProjectCareerVariables } from '@dataconnect/generated';

// The `CreateProjectCareer` mutation requires an argument of type `CreateProjectCareerVariables`:
const createProjectCareerVars: CreateProjectCareerVariables = {
  projectId: ..., 
  careerId: ..., 
};

// Call the `createProjectCareer()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await createProjectCareer(createProjectCareerVars);
// Variables can be defined inline as well.
const { data } = await createProjectCareer({ projectId: ..., careerId: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await createProjectCareer(dataConnect, createProjectCareerVars);

console.log(data.projectCareer_insert);

// Or, you can use the `Promise` API.
createProjectCareer(createProjectCareerVars).then((response) => {
  const data = response.data;
  console.log(data.projectCareer_insert);
});
```

### Using `CreateProjectCareer`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, createProjectCareerRef, CreateProjectCareerVariables } from '@dataconnect/generated';

// The `CreateProjectCareer` mutation requires an argument of type `CreateProjectCareerVariables`:
const createProjectCareerVars: CreateProjectCareerVariables = {
  projectId: ..., 
  careerId: ..., 
};

// Call the `createProjectCareerRef()` function to get a reference to the mutation.
const ref = createProjectCareerRef(createProjectCareerVars);
// Variables can be defined inline as well.
const ref = createProjectCareerRef({ projectId: ..., careerId: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = createProjectCareerRef(dataConnect, createProjectCareerVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.projectCareer_insert);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.projectCareer_insert);
});
```

## UpdateProjectSchedule
You can execute the `UpdateProjectSchedule` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
updateProjectSchedule(vars: UpdateProjectScheduleVariables): MutationPromise<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;

interface UpdateProjectScheduleRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: UpdateProjectScheduleVariables): MutationRef<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;
}
export const updateProjectScheduleRef: UpdateProjectScheduleRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
updateProjectSchedule(dc: DataConnect, vars: UpdateProjectScheduleVariables): MutationPromise<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;

interface UpdateProjectScheduleRef {
  ...
  (dc: DataConnect, vars: UpdateProjectScheduleVariables): MutationRef<UpdateProjectScheduleData, UpdateProjectScheduleVariables>;
}
export const updateProjectScheduleRef: UpdateProjectScheduleRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the updateProjectScheduleRef:
```typescript
const name = updateProjectScheduleRef.operationName;
console.log(name);
```

### Variables
The `UpdateProjectSchedule` mutation requires an argument of type `UpdateProjectScheduleVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface UpdateProjectScheduleVariables {
  id: UUIDString;
  dayOfWeek: number;
  startHour: string;
  endHour: string;
}
```
### Return Type
Recall that executing the `UpdateProjectSchedule` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `UpdateProjectScheduleData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface UpdateProjectScheduleData {
  projectSchedule_update?: ProjectSchedule_Key | null;
}
```
### Using `UpdateProjectSchedule`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, updateProjectSchedule, UpdateProjectScheduleVariables } from '@dataconnect/generated';

// The `UpdateProjectSchedule` mutation requires an argument of type `UpdateProjectScheduleVariables`:
const updateProjectScheduleVars: UpdateProjectScheduleVariables = {
  id: ..., 
  dayOfWeek: ..., 
  startHour: ..., 
  endHour: ..., 
};

// Call the `updateProjectSchedule()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await updateProjectSchedule(updateProjectScheduleVars);
// Variables can be defined inline as well.
const { data } = await updateProjectSchedule({ id: ..., dayOfWeek: ..., startHour: ..., endHour: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await updateProjectSchedule(dataConnect, updateProjectScheduleVars);

console.log(data.projectSchedule_update);

// Or, you can use the `Promise` API.
updateProjectSchedule(updateProjectScheduleVars).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_update);
});
```

### Using `UpdateProjectSchedule`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, updateProjectScheduleRef, UpdateProjectScheduleVariables } from '@dataconnect/generated';

// The `UpdateProjectSchedule` mutation requires an argument of type `UpdateProjectScheduleVariables`:
const updateProjectScheduleVars: UpdateProjectScheduleVariables = {
  id: ..., 
  dayOfWeek: ..., 
  startHour: ..., 
  endHour: ..., 
};

// Call the `updateProjectScheduleRef()` function to get a reference to the mutation.
const ref = updateProjectScheduleRef(updateProjectScheduleVars);
// Variables can be defined inline as well.
const ref = updateProjectScheduleRef({ id: ..., dayOfWeek: ..., startHour: ..., endHour: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = updateProjectScheduleRef(dataConnect, updateProjectScheduleVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.projectSchedule_update);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_update);
});
```

## DeleteProjectSchedule
You can execute the `DeleteProjectSchedule` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
deleteProjectSchedule(vars: DeleteProjectScheduleVariables): MutationPromise<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;

interface DeleteProjectScheduleRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: DeleteProjectScheduleVariables): MutationRef<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;
}
export const deleteProjectScheduleRef: DeleteProjectScheduleRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
deleteProjectSchedule(dc: DataConnect, vars: DeleteProjectScheduleVariables): MutationPromise<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;

interface DeleteProjectScheduleRef {
  ...
  (dc: DataConnect, vars: DeleteProjectScheduleVariables): MutationRef<DeleteProjectScheduleData, DeleteProjectScheduleVariables>;
}
export const deleteProjectScheduleRef: DeleteProjectScheduleRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the deleteProjectScheduleRef:
```typescript
const name = deleteProjectScheduleRef.operationName;
console.log(name);
```

### Variables
The `DeleteProjectSchedule` mutation requires an argument of type `DeleteProjectScheduleVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface DeleteProjectScheduleVariables {
  id: UUIDString;
}
```
### Return Type
Recall that executing the `DeleteProjectSchedule` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `DeleteProjectScheduleData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface DeleteProjectScheduleData {
  projectSchedule_delete?: ProjectSchedule_Key | null;
}
```
### Using `DeleteProjectSchedule`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, deleteProjectSchedule, DeleteProjectScheduleVariables } from '@dataconnect/generated';

// The `DeleteProjectSchedule` mutation requires an argument of type `DeleteProjectScheduleVariables`:
const deleteProjectScheduleVars: DeleteProjectScheduleVariables = {
  id: ..., 
};

// Call the `deleteProjectSchedule()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await deleteProjectSchedule(deleteProjectScheduleVars);
// Variables can be defined inline as well.
const { data } = await deleteProjectSchedule({ id: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await deleteProjectSchedule(dataConnect, deleteProjectScheduleVars);

console.log(data.projectSchedule_delete);

// Or, you can use the `Promise` API.
deleteProjectSchedule(deleteProjectScheduleVars).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_delete);
});
```

### Using `DeleteProjectSchedule`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, deleteProjectScheduleRef, DeleteProjectScheduleVariables } from '@dataconnect/generated';

// The `DeleteProjectSchedule` mutation requires an argument of type `DeleteProjectScheduleVariables`:
const deleteProjectScheduleVars: DeleteProjectScheduleVariables = {
  id: ..., 
};

// Call the `deleteProjectScheduleRef()` function to get a reference to the mutation.
const ref = deleteProjectScheduleRef(deleteProjectScheduleVars);
// Variables can be defined inline as well.
const ref = deleteProjectScheduleRef({ id: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = deleteProjectScheduleRef(dataConnect, deleteProjectScheduleVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.projectSchedule_delete);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_delete);
});
```

## SeedProjectSchedule
You can execute the `SeedProjectSchedule` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
seedProjectSchedule(): MutationPromise<SeedProjectScheduleData, undefined>;

interface SeedProjectScheduleRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedProjectScheduleData, undefined>;
}
export const seedProjectScheduleRef: SeedProjectScheduleRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
seedProjectSchedule(dc: DataConnect): MutationPromise<SeedProjectScheduleData, undefined>;

interface SeedProjectScheduleRef {
  ...
  (dc: DataConnect): MutationRef<SeedProjectScheduleData, undefined>;
}
export const seedProjectScheduleRef: SeedProjectScheduleRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the seedProjectScheduleRef:
```typescript
const name = seedProjectScheduleRef.operationName;
console.log(name);
```

### Variables
The `SeedProjectSchedule` mutation has no variables.
### Return Type
Recall that executing the `SeedProjectSchedule` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `SeedProjectScheduleData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface SeedProjectScheduleData {
  marteManana: ProjectSchedule_Key;
  martesTarde: ProjectSchedule_Key;
  Miercoles: ProjectSchedule_Key;
}
```
### Using `SeedProjectSchedule`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, seedProjectSchedule } from '@dataconnect/generated';


// Call the `seedProjectSchedule()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await seedProjectSchedule();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await seedProjectSchedule(dataConnect);

console.log(data.marteManana);
console.log(data.martesTarde);
console.log(data.Miercoles);

// Or, you can use the `Promise` API.
seedProjectSchedule().then((response) => {
  const data = response.data;
  console.log(data.marteManana);
  console.log(data.martesTarde);
  console.log(data.Miercoles);
});
```

### Using `SeedProjectSchedule`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, seedProjectScheduleRef } from '@dataconnect/generated';


// Call the `seedProjectScheduleRef()` function to get a reference to the mutation.
const ref = seedProjectScheduleRef();

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = seedProjectScheduleRef(dataConnect);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.marteManana);
console.log(data.martesTarde);
console.log(data.Miercoles);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.marteManana);
  console.log(data.martesTarde);
  console.log(data.Miercoles);
});
```

## CreateProjectSchedule
You can execute the `CreateProjectSchedule` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
createProjectSchedule(vars: CreateProjectScheduleVariables): MutationPromise<CreateProjectScheduleData, CreateProjectScheduleVariables>;

interface CreateProjectScheduleRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (vars: CreateProjectScheduleVariables): MutationRef<CreateProjectScheduleData, CreateProjectScheduleVariables>;
}
export const createProjectScheduleRef: CreateProjectScheduleRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
createProjectSchedule(dc: DataConnect, vars: CreateProjectScheduleVariables): MutationPromise<CreateProjectScheduleData, CreateProjectScheduleVariables>;

interface CreateProjectScheduleRef {
  ...
  (dc: DataConnect, vars: CreateProjectScheduleVariables): MutationRef<CreateProjectScheduleData, CreateProjectScheduleVariables>;
}
export const createProjectScheduleRef: CreateProjectScheduleRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the createProjectScheduleRef:
```typescript
const name = createProjectScheduleRef.operationName;
console.log(name);
```

### Variables
The `CreateProjectSchedule` mutation requires an argument of type `CreateProjectScheduleVariables`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:

```typescript
export interface CreateProjectScheduleVariables {
  participantId: UUIDString;
  dayOfWeek: number;
  startHour: string;
  endHour: string;
}
```
### Return Type
Recall that executing the `CreateProjectSchedule` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `CreateProjectScheduleData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface CreateProjectScheduleData {
  projectSchedule_insert: ProjectSchedule_Key;
}
```
### Using `CreateProjectSchedule`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, createProjectSchedule, CreateProjectScheduleVariables } from '@dataconnect/generated';

// The `CreateProjectSchedule` mutation requires an argument of type `CreateProjectScheduleVariables`:
const createProjectScheduleVars: CreateProjectScheduleVariables = {
  participantId: ..., 
  dayOfWeek: ..., 
  startHour: ..., 
  endHour: ..., 
};

// Call the `createProjectSchedule()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await createProjectSchedule(createProjectScheduleVars);
// Variables can be defined inline as well.
const { data } = await createProjectSchedule({ participantId: ..., dayOfWeek: ..., startHour: ..., endHour: ..., });

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await createProjectSchedule(dataConnect, createProjectScheduleVars);

console.log(data.projectSchedule_insert);

// Or, you can use the `Promise` API.
createProjectSchedule(createProjectScheduleVars).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_insert);
});
```

### Using `CreateProjectSchedule`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, createProjectScheduleRef, CreateProjectScheduleVariables } from '@dataconnect/generated';

// The `CreateProjectSchedule` mutation requires an argument of type `CreateProjectScheduleVariables`:
const createProjectScheduleVars: CreateProjectScheduleVariables = {
  participantId: ..., 
  dayOfWeek: ..., 
  startHour: ..., 
  endHour: ..., 
};

// Call the `createProjectScheduleRef()` function to get a reference to the mutation.
const ref = createProjectScheduleRef(createProjectScheduleVars);
// Variables can be defined inline as well.
const ref = createProjectScheduleRef({ participantId: ..., dayOfWeek: ..., startHour: ..., endHour: ..., });

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = createProjectScheduleRef(dataConnect, createProjectScheduleVars);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.projectSchedule_insert);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.projectSchedule_insert);
});
```

## SeedProjectType
You can execute the `SeedProjectType` mutation using the following action shortcut function, or by calling `executeMutation()` after calling the following `MutationRef` function, both of which are defined in [dataconnect-generated/index.d.ts](./index.d.ts):
```typescript
seedProjectType(): MutationPromise<SeedProjectTypeData, undefined>;

interface SeedProjectTypeRef {
  ...
  /* Allow users to create refs without passing in DataConnect */
  (): MutationRef<SeedProjectTypeData, undefined>;
}
export const seedProjectTypeRef: SeedProjectTypeRef;
```
You can also pass in a `DataConnect` instance to the action shortcut function or `MutationRef` function.
```typescript
seedProjectType(dc: DataConnect): MutationPromise<SeedProjectTypeData, undefined>;

interface SeedProjectTypeRef {
  ...
  (dc: DataConnect): MutationRef<SeedProjectTypeData, undefined>;
}
export const seedProjectTypeRef: SeedProjectTypeRef;
```

If you need the name of the operation without creating a ref, you can retrieve the operation name by calling the `operationName` property on the seedProjectTypeRef:
```typescript
const name = seedProjectTypeRef.operationName;
console.log(name);
```

### Variables
The `SeedProjectType` mutation has no variables.
### Return Type
Recall that executing the `SeedProjectType` mutation returns a `MutationPromise` that resolves to an object with a `data` property.

The `data` property is an object of type `SeedProjectTypeData`, which is defined in [dataconnect-generated/index.d.ts](./index.d.ts). It has the following fields:
```typescript
export interface SeedProjectTypeData {
  servicio_interno: ProjectType_Key;
  servicio_externo: ProjectType_Key;
}
```
### Using `SeedProjectType`'s action shortcut function

```typescript
import { getDataConnect } from 'firebase/data-connect';
import { connectorConfig, seedProjectType } from '@dataconnect/generated';


// Call the `seedProjectType()` function to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await seedProjectType();

// You can also pass in a `DataConnect` instance to the action shortcut function.
const dataConnect = getDataConnect(connectorConfig);
const { data } = await seedProjectType(dataConnect);

console.log(data.servicio_interno);
console.log(data.servicio_externo);

// Or, you can use the `Promise` API.
seedProjectType().then((response) => {
  const data = response.data;
  console.log(data.servicio_interno);
  console.log(data.servicio_externo);
});
```

### Using `SeedProjectType`'s `MutationRef` function

```typescript
import { getDataConnect, executeMutation } from 'firebase/data-connect';
import { connectorConfig, seedProjectTypeRef } from '@dataconnect/generated';


// Call the `seedProjectTypeRef()` function to get a reference to the mutation.
const ref = seedProjectTypeRef();

// You can also pass in a `DataConnect` instance to the `MutationRef` function.
const dataConnect = getDataConnect(connectorConfig);
const ref = seedProjectTypeRef(dataConnect);

// Call `executeMutation()` on the reference to execute the mutation.
// You can use the `await` keyword to wait for the promise to resolve.
const { data } = await executeMutation(ref);

console.log(data.servicio_interno);
console.log(data.servicio_externo);

// Or, you can use the `Promise` API.
executeMutation(ref).then((response) => {
  const data = response.data;
  console.log(data.servicio_interno);
  console.log(data.servicio_externo);
});
```

