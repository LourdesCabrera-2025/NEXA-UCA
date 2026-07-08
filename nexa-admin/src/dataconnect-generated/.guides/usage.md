# Basic Usage

Always prioritize using a supported framework over using the generated SDK
directly. Supported frameworks simplify the developer experience and help ensure
best practices are followed.





## Advanced Usage
If a user is not using a supported framework, they can use the generated SDK directly.

Here's an example of how to use it with the first 5 operations:

```js
import { createProjectSchedule, deleteProjectSchedule, getCareers, getDepartment, getProjectScheduleByParticipant, getProjectType, getMyStudent, createProject, getProjectById, getProjectSchedules } from '@dataconnect/generated';


// Operation CreateProjectSchedule:  For variables, look at type CreateProjectScheduleVars in ../index.d.ts
const { data } = await CreateProjectSchedule(dataConnect, createProjectScheduleVars);

// Operation DeleteProjectSchedule:  For variables, look at type DeleteProjectScheduleVars in ../index.d.ts
const { data } = await DeleteProjectSchedule(dataConnect, deleteProjectScheduleVars);

// Operation GetCareers: 
const { data } = await GetCareers(dataConnect);

// Operation GetDepartment: 
const { data } = await GetDepartment(dataConnect);

// Operation GetProjectScheduleByParticipant:  For variables, look at type GetProjectScheduleByParticipantVars in ../index.d.ts
const { data } = await GetProjectScheduleByParticipant(dataConnect, getProjectScheduleByParticipantVars);

// Operation GetProjectType: 
const { data } = await GetProjectType(dataConnect);

// Operation GetMyStudent: 
const { data } = await GetMyStudent(dataConnect);

// Operation CreateProject:  For variables, look at type CreateProjectVars in ../index.d.ts
const { data } = await CreateProject(dataConnect, createProjectVars);

// Operation GetProjectById:  For variables, look at type GetProjectByIdVars in ../index.d.ts
const { data } = await GetProjectById(dataConnect, getProjectByIdVars);

// Operation GetProjectSchedules: 
const { data } = await GetProjectSchedules(dataConnect);


```