# Basic Usage

Always prioritize using a supported framework over using the generated SDK
directly. Supported frameworks simplify the developer experience and help ensure
best practices are followed.





## Advanced Usage
If a user is not using a supported framework, they can use the generated SDK directly.

Here's an example of how to use it with the first 5 operations:

```js
import { getDepartment, getProjectCareers, getProjectScheduleByParticipant, createProject, getUserById, createUser, createStudent, getProjectType, getRoles, getMyStudent } from '@dataconnect/generated';


// Operation GetDepartment: 
const { data } = await GetDepartment(dataConnect);

// Operation GetProjectCareers:  For variables, look at type GetProjectCareersVars in ../index.d.ts
const { data } = await GetProjectCareers(dataConnect, getProjectCareersVars);

// Operation GetProjectScheduleByParticipant:  For variables, look at type GetProjectScheduleByParticipantVars in ../index.d.ts
const { data } = await GetProjectScheduleByParticipant(dataConnect, getProjectScheduleByParticipantVars);

// Operation CreateProject:  For variables, look at type CreateProjectVars in ../index.d.ts
const { data } = await CreateProject(dataConnect, createProjectVars);

// Operation GetUserById:  For variables, look at type GetUserByIdVars in ../index.d.ts
const { data } = await GetUserById(dataConnect, getUserByIdVars);

// Operation CreateUser:  For variables, look at type CreateUserVars in ../index.d.ts
const { data } = await CreateUser(dataConnect, createUserVars);

// Operation CreateStudent:  For variables, look at type CreateStudentVars in ../index.d.ts
const { data } = await CreateStudent(dataConnect, createStudentVars);

// Operation GetProjectType: 
const { data } = await GetProjectType(dataConnect);

// Operation GetRoles: 
const { data } = await GetRoles(dataConnect);

// Operation GetMyStudent: 
const { data } = await GetMyStudent(dataConnect);


```