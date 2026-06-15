# Basic Usage

Always prioritize using a supported framework over using the generated SDK
directly. Supported frameworks simplify the developer experience and help ensure
best practices are followed.




### React
For each operation, there is a wrapper hook that can be used to call the operation.

Here are all of the hooks that get generated:
```ts
import { useGetMyStudent, useGetUserById, useCreateUser, useCreateStudent, useGetCareers, useGetDepartment, useGetRoleByName, useGetRoles } from '@dataconnect/generated/react';
// The types of these hooks are available in react/index.d.ts

const { data, isPending, isSuccess, isError, error } = useGetMyStudent();

const { data, isPending, isSuccess, isError, error } = useGetUserById(getUserByIdVars);

const { data, isPending, isSuccess, isError, error } = useCreateUser(createUserVars);

const { data, isPending, isSuccess, isError, error } = useCreateStudent(createStudentVars);

const { data, isPending, isSuccess, isError, error } = useGetCareers();

const { data, isPending, isSuccess, isError, error } = useGetDepartment();

const { data, isPending, isSuccess, isError, error } = useGetRoleByName(getRoleByNameVars);

const { data, isPending, isSuccess, isError, error } = useGetRoles();

```

Here's an example from a different generated SDK:

```ts
import { useListAllMovies } from '@dataconnect/generated/react';

function MyComponent() {
  const { isLoading, data, error } = useListAllMovies();
  if(isLoading) {
    return <div>Loading...</div>
  }
  if(error) {
    return <div> An Error Occurred: {error} </div>
  }
}

// App.tsx
import { QueryClient, QueryClientProvider } from '@tanstack/react-query';
import MyComponent from './my-component';

function App() {
  const queryClient = new QueryClient();
  return <QueryClientProvider client={queryClient}>
    <MyComponent />
  </QueryClientProvider>
}
```



## Advanced Usage
If a user is not using a supported framework, they can use the generated SDK directly.

Here's an example of how to use it with the first 5 operations:

```js
import { getMyStudent, getUserById, createUser, createStudent, getCareers, getDepartment, getRoleByName, getRoles } from '@dataconnect/generated';


// Operation GetMyStudent: 
const { data } = await GetMyStudent(dataConnect);

// Operation GetUserById:  For variables, look at type GetUserByIdVars in ../index.d.ts
const { data } = await GetUserById(dataConnect, getUserByIdVars);

// Operation CreateUser:  For variables, look at type CreateUserVars in ../index.d.ts
const { data } = await CreateUser(dataConnect, createUserVars);

// Operation CreateStudent:  For variables, look at type CreateStudentVars in ../index.d.ts
const { data } = await CreateStudent(dataConnect, createStudentVars);

// Operation GetCareers: 
const { data } = await GetCareers(dataConnect);

// Operation GetDepartment: 
const { data } = await GetDepartment(dataConnect);

// Operation GetRoleByName:  For variables, look at type GetRoleByNameVars in ../index.d.ts
const { data } = await GetRoleByName(dataConnect, getRoleByNameVars);

// Operation GetRoles: 
const { data } = await GetRoles(dataConnect);


```