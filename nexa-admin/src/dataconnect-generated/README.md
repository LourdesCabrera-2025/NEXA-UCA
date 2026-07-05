# Generated TypeScript README
This README will guide you through the process of using the generated JavaScript SDK package for the connector `nexa`. It will also provide examples on how to use your generated SDK to call your Data Connect queries and mutations.

**If you're looking for the `React README`, you can find it at [`dataconnect-generated/react/README.md`](./react/README.md)**

***NOTE:** This README is generated alongside the generated SDK. If you make changes to this file, they will be overwritten when the SDK is regenerated.*

# Table of Contents
- [**Overview**](#generated-javascript-readme)
- [**Accessing the connector**](#accessing-the-connector)
  - [*Connecting to the local Emulator*](#connecting-to-the-local-emulator)
- [**Queries**](#queries)
  - [*GetMyStudent*](#getmystudent)
  - [*GetUserById*](#getuserbyid)
  - [*GetCareers*](#getcareers)
  - [*GetDepartment*](#getdepartment)
  - [*GetRoleByName*](#getrolebyname)
  - [*GetRoles*](#getroles)
- [**Mutations**](#mutations)
  - [*CreateUser*](#createuser)
  - [*CreateStudent*](#createstudent)

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

