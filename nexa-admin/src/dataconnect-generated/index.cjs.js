const { queryRef, executeQuery, validateArgsWithOptions, mutationRef, executeMutation, validateArgs, makeMemoryCacheProvider } = require('firebase/data-connect');

const connectorConfig = {
  connector: 'nexa',
  service: 'nexauca',
  location: 'us-central1'
};
exports.connectorConfig = connectorConfig;
const dataConnectSettings = {
  cacheSettings: {
    cacheProvider: makeMemoryCacheProvider()
  }
};
exports.dataConnectSettings = dataConnectSettings;

const getDepartmentRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetDepartment');
}
getDepartmentRef.operationName = 'GetDepartment';
exports.getDepartmentRef = getDepartmentRef;

exports.getDepartment = function getDepartment(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getDepartmentRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getProjectCareersRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjectCareers', inputVars);
}
getProjectCareersRef.operationName = 'GetProjectCareers';
exports.getProjectCareersRef = getProjectCareersRef;

exports.getProjectCareers = function getProjectCareers(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getProjectCareersRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getProjectScheduleByParticipantRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjectScheduleByParticipant', inputVars);
}
getProjectScheduleByParticipantRef.operationName = 'GetProjectScheduleByParticipant';
exports.getProjectScheduleByParticipantRef = getProjectScheduleByParticipantRef;

exports.getProjectScheduleByParticipant = function getProjectScheduleByParticipant(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getProjectScheduleByParticipantRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const createProjectRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'CreateProject', inputVars);
}
createProjectRef.operationName = 'CreateProject';
exports.createProjectRef = createProjectRef;

exports.createProject = function createProject(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(createProjectRef(dcInstance, inputVars));
}
;

const getUserByIdRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetUserById', inputVars);
}
getUserByIdRef.operationName = 'GetUserById';
exports.getUserByIdRef = getUserByIdRef;

exports.getUserById = function getUserById(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getUserByIdRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const createUserRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'CreateUser', inputVars);
}
createUserRef.operationName = 'CreateUser';
exports.createUserRef = createUserRef;

exports.createUser = function createUser(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(createUserRef(dcInstance, inputVars));
}
;

const createStudentRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'CreateStudent', inputVars);
}
createStudentRef.operationName = 'CreateStudent';
exports.createStudentRef = createStudentRef;

exports.createStudent = function createStudent(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(createStudentRef(dcInstance, inputVars));
}
;

const getProjectTypeRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjectType');
}
getProjectTypeRef.operationName = 'GetProjectType';
exports.getProjectTypeRef = getProjectTypeRef;

exports.getProjectType = function getProjectType(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getProjectTypeRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getRolesRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetRoles');
}
getRolesRef.operationName = 'GetRoles';
exports.getRolesRef = getRolesRef;

exports.getRoles = function getRoles(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getRolesRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getMyStudentRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetMyStudent');
}
getMyStudentRef.operationName = 'GetMyStudent';
exports.getMyStudentRef = getMyStudentRef;

exports.getMyStudent = function getMyStudent(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getMyStudentRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const seedParticipantsRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'SeedParticipants');
}
seedParticipantsRef.operationName = 'SeedParticipants';
exports.seedParticipantsRef = seedParticipantsRef;

exports.seedParticipants = function seedParticipants(dc) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dc, undefined);
  return executeMutation(seedParticipantsRef(dcInstance, inputVars));
}
;

const createProjectCareerRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'CreateProjectCareer', inputVars);
}
createProjectCareerRef.operationName = 'CreateProjectCareer';
exports.createProjectCareerRef = createProjectCareerRef;

exports.createProjectCareer = function createProjectCareer(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(createProjectCareerRef(dcInstance, inputVars));
}
;

const updateProjectScheduleRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'UpdateProjectSchedule', inputVars);
}
updateProjectScheduleRef.operationName = 'UpdateProjectSchedule';
exports.updateProjectScheduleRef = updateProjectScheduleRef;

exports.updateProjectSchedule = function updateProjectSchedule(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(updateProjectScheduleRef(dcInstance, inputVars));
}
;

const deleteProjectScheduleRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'DeleteProjectSchedule', inputVars);
}
deleteProjectScheduleRef.operationName = 'DeleteProjectSchedule';
exports.deleteProjectScheduleRef = deleteProjectScheduleRef;

exports.deleteProjectSchedule = function deleteProjectSchedule(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(deleteProjectScheduleRef(dcInstance, inputVars));
}
;

const getCareersRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetCareers');
}
getCareersRef.operationName = 'GetCareers';
exports.getCareersRef = getCareersRef;

exports.getCareers = function getCareers(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getCareersRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getParticipantsByProjectRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetParticipantsByProject', inputVars);
}
getParticipantsByProjectRef.operationName = 'GetParticipantsByProject';
exports.getParticipantsByProjectRef = getParticipantsByProjectRef;

exports.getParticipantsByProject = function getParticipantsByProject(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getParticipantsByProjectRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getProjectByIdRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjectById', inputVars);
}
getProjectByIdRef.operationName = 'GetProjectById';
exports.getProjectByIdRef = getProjectByIdRef;

exports.getProjectById = function getProjectById(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getProjectByIdRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getRoleByNameRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetRoleByName', inputVars);
}
getRoleByNameRef.operationName = 'GetRoleByName';
exports.getRoleByNameRef = getRoleByNameRef;

exports.getRoleByName = function getRoleByName(dcOrVars, varsOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrVars, varsOrOptions, options, true, true);
  return executeQuery(getRoleByNameRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const seedProjectScheduleRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'SeedProjectSchedule');
}
seedProjectScheduleRef.operationName = 'SeedProjectSchedule';
exports.seedProjectScheduleRef = seedProjectScheduleRef;

exports.seedProjectSchedule = function seedProjectSchedule(dc) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dc, undefined);
  return executeMutation(seedProjectScheduleRef(dcInstance, inputVars));
}
;

const getProjectSchedulesRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjectSchedules');
}
getProjectSchedulesRef.operationName = 'GetProjectSchedules';
exports.getProjectSchedulesRef = getProjectSchedulesRef;

exports.getProjectSchedules = function getProjectSchedules(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getProjectSchedulesRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const getProjectsRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return queryRef(dcInstance, 'GetProjects');
}
getProjectsRef.operationName = 'GetProjects';
exports.getProjectsRef = getProjectsRef;

exports.getProjects = function getProjects(dcOrOptions, options) {
  
  const { dc: dcInstance, vars: inputVars, options: inputOpts } = validateArgsWithOptions(connectorConfig, dcOrOptions, options, undefined,false, false);
  return executeQuery(getProjectsRef(dcInstance, inputVars), inputOpts && inputOpts.fetchPolicy);
}
;

const createProjectScheduleRef = (dcOrVars, vars) => {
  const { dc: dcInstance, vars: inputVars} = validateArgs(connectorConfig, dcOrVars, vars, true);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'CreateProjectSchedule', inputVars);
}
createProjectScheduleRef.operationName = 'CreateProjectSchedule';
exports.createProjectScheduleRef = createProjectScheduleRef;

exports.createProjectSchedule = function createProjectSchedule(dcOrVars, vars) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dcOrVars, vars, true);
  return executeMutation(createProjectScheduleRef(dcInstance, inputVars));
}
;

const seedProjectTypeRef = (dc) => {
  const { dc: dcInstance} = validateArgs(connectorConfig, dc, undefined);
  dcInstance._useGeneratedSdk();
  return mutationRef(dcInstance, 'SeedProjectType');
}
seedProjectTypeRef.operationName = 'SeedProjectType';
exports.seedProjectTypeRef = seedProjectTypeRef;

exports.seedProjectType = function seedProjectType(dc) {
  const { dc: dcInstance, vars: inputVars } = validateArgs(connectorConfig, dc, undefined);
  return executeMutation(seedProjectTypeRef(dcInstance, inputVars));
}
;
