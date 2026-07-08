
@file:Suppress(
  "KotlinRedundantDiagnosticSuppress",
  "PropertyName",
  "MayBeConstant",
  "RedundantVisibilityModifier",
  "RedundantCompanionReference",
  "RemoveEmptyClassBody",
  "SpellCheckingInspection",
  "unused",
)

package sv.uca.nexauca.dataconnect

import com.google.firebase.dataconnect.getInstance as _fdcGetInstance
import kotlin.time.Duration.Companion.milliseconds as _milliseconds

public interface NexaConnector : com.google.firebase.dataconnect.generated.GeneratedConnector<NexaConnector> {
  override val dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect

  
    public val createProject: CreateProjectMutation
  
    public val createProjectCareer: CreateProjectCareerMutation
  
    public val createProjectSchedule: CreateProjectScheduleMutation
  
    public val createStudent: CreateStudentMutation
  
    public val createUser: CreateUserMutation
  
    public val deleteProjectSchedule: DeleteProjectScheduleMutation
  
    public val getActividadReciente: GetActividadRecienteQuery
  
    public val getActividadesUsuario: GetActividadesUsuarioQuery
  
    public val getAsistenciasSemana: GetAsistenciasSemanaQuery
  
    public val getCareers: GetCareersQuery
  
    public val getDepartment: GetDepartmentQuery
  
    public val getHorasPorTipo: GetHorasPorTipoQuery
  
    public val getMyStudent: GetMyStudentQuery
  
    public val getParticipantsByProject: GetParticipantsByProjectQuery
  
    public val getProjectById: GetProjectByIdQuery
  
    public val getProjectCareers: GetProjectCareersQuery
  
    public val getProjectScheduleByParticipant: GetProjectScheduleByParticipantQuery
  
    public val getProjectSchedules: GetProjectSchedulesQuery
  
    public val getProjectType: GetProjectTypeQuery
  
    public val getProjects: GetProjectsQuery
  
    public val getRoleByName: GetRoleByNameQuery
  
    public val getRoles: GetRolesQuery
  
    public val getTodasActividades: GetTodasActividadesQuery
  
    public val getUserById: GetUserByIdQuery
  
    public val seedParticipants: SeedParticipantsMutation
  
    public val seedProjectSchedule: SeedProjectScheduleMutation
  
    public val seedProjectType: SeedProjectTypeMutation
  
    public val updateProjectSchedule: UpdateProjectScheduleMutation
  

  public companion object {
    @Suppress("MemberVisibilityCanBePrivate")
    public val config: com.google.firebase.dataconnect.ConnectorConfig = com.google.firebase.dataconnect.ConnectorConfig(
      connector = "nexa",
      location = "us-central1",
      serviceId = "nexauca",
    )

    public fun getInstance(
      dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect
    ):NexaConnector = synchronized(instances) {
      instances.getOrPut(dataConnect) {
        NexaConnectorImpl(dataConnect)
      }
    }

    private val instances = java.util.WeakHashMap<com.google.firebase.dataconnect.FirebaseDataConnect, NexaConnectorImpl>()

    
  }
}

public val NexaConnector.Companion.instance:NexaConnector
  get() = getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(
    config
  ))

public fun NexaConnector.Companion.getInstance(
  settings: com.google.firebase.dataconnect.DataConnectSettings = com.google.firebase.dataconnect.DataConnectSettings()
):NexaConnector =
  getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(config, settings))

public fun NexaConnector.Companion.getInstance(
  app: com.google.firebase.FirebaseApp,
  settings: com.google.firebase.dataconnect.DataConnectSettings = com.google.firebase.dataconnect.DataConnectSettings()
):NexaConnector =
  getInstance(com.google.firebase.dataconnect.FirebaseDataConnect._fdcGetInstance(app, config, settings))

private class NexaConnectorImpl(
  override val dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect
) : NexaConnector {
  
    override val createProject by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateProjectMutationImpl(this)
    }
  
    override val createProjectCareer by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateProjectCareerMutationImpl(this)
    }
  
    override val createProjectSchedule by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateProjectScheduleMutationImpl(this)
    }
  
    override val createStudent by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateStudentMutationImpl(this)
    }
  
    override val createUser by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateUserMutationImpl(this)
    }
  
    override val deleteProjectSchedule by lazy(LazyThreadSafetyMode.PUBLICATION) {
      DeleteProjectScheduleMutationImpl(this)
    }
  
    override val getActividadReciente by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetActividadRecienteQueryImpl(this)
    }
  
    override val getActividadesUsuario by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetActividadesUsuarioQueryImpl(this)
    }
  
    override val getAsistenciasSemana by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetAsistenciasSemanaQueryImpl(this)
    }
  
    override val getCareers by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetCareersQueryImpl(this)
    }
  
    override val getDepartment by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetDepartmentQueryImpl(this)
    }
  
    override val getHorasPorTipo by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetHorasPorTipoQueryImpl(this)
    }
  
    override val getMyStudent by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetMyStudentQueryImpl(this)
    }
  
    override val getParticipantsByProject by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetParticipantsByProjectQueryImpl(this)
    }
  
    override val getProjectById by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectByIdQueryImpl(this)
    }
  
    override val getProjectCareers by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectCareersQueryImpl(this)
    }
  
    override val getProjectScheduleByParticipant by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectScheduleByParticipantQueryImpl(this)
    }
  
    override val getProjectSchedules by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectSchedulesQueryImpl(this)
    }
  
    override val getProjectType by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectTypeQueryImpl(this)
    }
  
    override val getProjects by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectsQueryImpl(this)
    }
  
    override val getRoleByName by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetRoleByNameQueryImpl(this)
    }
  
    override val getRoles by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetRolesQueryImpl(this)
    }
  
    override val getTodasActividades by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetTodasActividadesQueryImpl(this)
    }
  
    override val getUserById by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetUserByIdQueryImpl(this)
    }
  
    override val seedParticipants by lazy(LazyThreadSafetyMode.PUBLICATION) {
      SeedParticipantsMutationImpl(this)
    }
  
    override val seedProjectSchedule by lazy(LazyThreadSafetyMode.PUBLICATION) {
      SeedProjectScheduleMutationImpl(this)
    }
  
    override val seedProjectType by lazy(LazyThreadSafetyMode.PUBLICATION) {
      SeedProjectTypeMutationImpl(this)
    }
  
    override val updateProjectSchedule by lazy(LazyThreadSafetyMode.PUBLICATION) {
      UpdateProjectScheduleMutationImpl(this)
    }
  

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun operations(): List<com.google.firebase.dataconnect.generated.GeneratedOperation<NexaConnector, *, *>> =
    queries() + mutations()

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun mutations(): List<com.google.firebase.dataconnect.generated.GeneratedMutation<NexaConnector, *, *>> =
    listOf(
      createProject,
        createProjectCareer,
        createProjectSchedule,
        createStudent,
        createUser,
        deleteProjectSchedule,
        seedParticipants,
        seedProjectSchedule,
        seedProjectType,
        updateProjectSchedule,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun queries(): List<com.google.firebase.dataconnect.generated.GeneratedQuery<NexaConnector, *, *>> =
    listOf(
      getActividadReciente,
        getActividadesUsuario,
        getAsistenciasSemana,
        getCareers,
        getDepartment,
        getHorasPorTipo,
        getMyStudent,
        getParticipantsByProject,
        getProjectById,
        getProjectCareers,
        getProjectScheduleByParticipant,
        getProjectSchedules,
        getProjectType,
        getProjects,
        getRoleByName,
        getRoles,
        getTodasActividades,
        getUserById,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect) =
    NexaConnectorImpl(dataConnect)

  override fun equals(other: Any?): Boolean =
    other is NexaConnectorImpl &&
    other.dataConnect == dataConnect

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "NexaConnectorImpl",
      dataConnect,
    )

  override fun toString(): String =
    "NexaConnectorImpl(dataConnect=$dataConnect)"
}



private open class NexaConnectorGeneratedQueryImpl<Data, Variables>(
  override val connector: NexaConnector,
  override val operationName: String,
  override val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
  override val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
) : com.google.firebase.dataconnect.generated.GeneratedQuery<NexaConnector, Data, Variables> {

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(
    connector: NexaConnector,
    operationName: String,
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
    variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
  ) =
    NexaConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewVariables> withVariablesSerializer(
    variablesSerializer: kotlinx.serialization.SerializationStrategy<NewVariables>
  ) =
    NexaConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewData> withDataDeserializer(
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<NewData>
  ) =
    NexaConnectorGeneratedQueryImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun equals(other: Any?): Boolean =
    other is NexaConnectorGeneratedQueryImpl<*,*> &&
    other.connector == connector &&
    other.operationName == operationName &&
    other.dataDeserializer == dataDeserializer &&
    other.variablesSerializer == variablesSerializer

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "NexaConnectorGeneratedQueryImpl",
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun toString(): String =
    "NexaConnectorGeneratedQueryImpl(" +
    "operationName=$operationName, " +
    "dataDeserializer=$dataDeserializer, " +
    "variablesSerializer=$variablesSerializer, " +
    "connector=$connector)"
}

private open class NexaConnectorGeneratedMutationImpl<Data, Variables>(
  override val connector: NexaConnector,
  override val operationName: String,
  override val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
  override val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
) : com.google.firebase.dataconnect.generated.GeneratedMutation<NexaConnector, Data, Variables> {

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun copy(
    connector: NexaConnector,
    operationName: String,
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data>,
    variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables>,
  ) =
    NexaConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewVariables> withVariablesSerializer(
    variablesSerializer: kotlinx.serialization.SerializationStrategy<NewVariables>
  ) =
    NexaConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun <NewData> withDataDeserializer(
    dataDeserializer: kotlinx.serialization.DeserializationStrategy<NewData>
  ) =
    NexaConnectorGeneratedMutationImpl(
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun equals(other: Any?): Boolean =
    other is NexaConnectorGeneratedMutationImpl<*,*> &&
    other.connector == connector &&
    other.operationName == operationName &&
    other.dataDeserializer == dataDeserializer &&
    other.variablesSerializer == variablesSerializer

  override fun hashCode(): Int =
    java.util.Objects.hash(
      "NexaConnectorGeneratedMutationImpl",
      connector, operationName, dataDeserializer, variablesSerializer
    )

  override fun toString(): String =
    "NexaConnectorGeneratedMutationImpl(" +
    "operationName=$operationName, " +
    "dataDeserializer=$dataDeserializer, " +
    "variablesSerializer=$variablesSerializer, " +
    "connector=$connector)"
}



private class CreateProjectMutationImpl(
  connector: NexaConnector
):
  CreateProjectMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateProjectMutation.Data,
      CreateProjectMutation.Variables
  >(
    connector,
    CreateProjectMutation.Companion.operationName,
    CreateProjectMutation.Companion.dataDeserializer,
    CreateProjectMutation.Companion.variablesSerializer,
  )


private class CreateProjectCareerMutationImpl(
  connector: NexaConnector
):
  CreateProjectCareerMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateProjectCareerMutation.Data,
      CreateProjectCareerMutation.Variables
  >(
    connector,
    CreateProjectCareerMutation.Companion.operationName,
    CreateProjectCareerMutation.Companion.dataDeserializer,
    CreateProjectCareerMutation.Companion.variablesSerializer,
  )


private class CreateProjectScheduleMutationImpl(
  connector: NexaConnector
):
  CreateProjectScheduleMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateProjectScheduleMutation.Data,
      CreateProjectScheduleMutation.Variables
  >(
    connector,
    CreateProjectScheduleMutation.Companion.operationName,
    CreateProjectScheduleMutation.Companion.dataDeserializer,
    CreateProjectScheduleMutation.Companion.variablesSerializer,
  )


private class CreateStudentMutationImpl(
  connector: NexaConnector
):
  CreateStudentMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateStudentMutation.Data,
      CreateStudentMutation.Variables
  >(
    connector,
    CreateStudentMutation.Companion.operationName,
    CreateStudentMutation.Companion.dataDeserializer,
    CreateStudentMutation.Companion.variablesSerializer,
  )


private class CreateUserMutationImpl(
  connector: NexaConnector
):
  CreateUserMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateUserMutation.Data,
      CreateUserMutation.Variables
  >(
    connector,
    CreateUserMutation.Companion.operationName,
    CreateUserMutation.Companion.dataDeserializer,
    CreateUserMutation.Companion.variablesSerializer,
  )


private class DeleteProjectScheduleMutationImpl(
  connector: NexaConnector
):
  DeleteProjectScheduleMutation,
  NexaConnectorGeneratedMutationImpl<
      DeleteProjectScheduleMutation.Data,
      DeleteProjectScheduleMutation.Variables
  >(
    connector,
    DeleteProjectScheduleMutation.Companion.operationName,
    DeleteProjectScheduleMutation.Companion.dataDeserializer,
    DeleteProjectScheduleMutation.Companion.variablesSerializer,
  )


private class GetActividadRecienteQueryImpl(
  connector: NexaConnector
):
  GetActividadRecienteQuery,
  NexaConnectorGeneratedQueryImpl<
      GetActividadRecienteQuery.Data,
      GetActividadRecienteQuery.Variables
  >(
    connector,
    GetActividadRecienteQuery.Companion.operationName,
    GetActividadRecienteQuery.Companion.dataDeserializer,
    GetActividadRecienteQuery.Companion.variablesSerializer,
  )


private class GetActividadesUsuarioQueryImpl(
  connector: NexaConnector
):
  GetActividadesUsuarioQuery,
  NexaConnectorGeneratedQueryImpl<
      GetActividadesUsuarioQuery.Data,
      GetActividadesUsuarioQuery.Variables
  >(
    connector,
    GetActividadesUsuarioQuery.Companion.operationName,
    GetActividadesUsuarioQuery.Companion.dataDeserializer,
    GetActividadesUsuarioQuery.Companion.variablesSerializer,
  )


private class GetAsistenciasSemanaQueryImpl(
  connector: NexaConnector
):
  GetAsistenciasSemanaQuery,
  NexaConnectorGeneratedQueryImpl<
      GetAsistenciasSemanaQuery.Data,
      GetAsistenciasSemanaQuery.Variables
  >(
    connector,
    GetAsistenciasSemanaQuery.Companion.operationName,
    GetAsistenciasSemanaQuery.Companion.dataDeserializer,
    GetAsistenciasSemanaQuery.Companion.variablesSerializer,
  )


private class GetCareersQueryImpl(
  connector: NexaConnector
):
  GetCareersQuery,
  NexaConnectorGeneratedQueryImpl<
      GetCareersQuery.Data,
      Unit
  >(
    connector,
    GetCareersQuery.Companion.operationName,
    GetCareersQuery.Companion.dataDeserializer,
    GetCareersQuery.Companion.variablesSerializer,
  )


private class GetDepartmentQueryImpl(
  connector: NexaConnector
):
  GetDepartmentQuery,
  NexaConnectorGeneratedQueryImpl<
      GetDepartmentQuery.Data,
      Unit
  >(
    connector,
    GetDepartmentQuery.Companion.operationName,
    GetDepartmentQuery.Companion.dataDeserializer,
    GetDepartmentQuery.Companion.variablesSerializer,
  )


private class GetHorasPorTipoQueryImpl(
  connector: NexaConnector
):
  GetHorasPorTipoQuery,
  NexaConnectorGeneratedQueryImpl<
      GetHorasPorTipoQuery.Data,
      GetHorasPorTipoQuery.Variables
  >(
    connector,
    GetHorasPorTipoQuery.Companion.operationName,
    GetHorasPorTipoQuery.Companion.dataDeserializer,
    GetHorasPorTipoQuery.Companion.variablesSerializer,
  )


private class GetMyStudentQueryImpl(
  connector: NexaConnector
):
  GetMyStudentQuery,
  NexaConnectorGeneratedQueryImpl<
      GetMyStudentQuery.Data,
      Unit
  >(
    connector,
    GetMyStudentQuery.Companion.operationName,
    GetMyStudentQuery.Companion.dataDeserializer,
    GetMyStudentQuery.Companion.variablesSerializer,
  )


private class GetParticipantsByProjectQueryImpl(
  connector: NexaConnector
):
  GetParticipantsByProjectQuery,
  NexaConnectorGeneratedQueryImpl<
      GetParticipantsByProjectQuery.Data,
      GetParticipantsByProjectQuery.Variables
  >(
    connector,
    GetParticipantsByProjectQuery.Companion.operationName,
    GetParticipantsByProjectQuery.Companion.dataDeserializer,
    GetParticipantsByProjectQuery.Companion.variablesSerializer,
  )


private class GetProjectByIdQueryImpl(
  connector: NexaConnector
):
  GetProjectByIdQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectByIdQuery.Data,
      GetProjectByIdQuery.Variables
  >(
    connector,
    GetProjectByIdQuery.Companion.operationName,
    GetProjectByIdQuery.Companion.dataDeserializer,
    GetProjectByIdQuery.Companion.variablesSerializer,
  )


private class GetProjectCareersQueryImpl(
  connector: NexaConnector
):
  GetProjectCareersQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectCareersQuery.Data,
      GetProjectCareersQuery.Variables
  >(
    connector,
    GetProjectCareersQuery.Companion.operationName,
    GetProjectCareersQuery.Companion.dataDeserializer,
    GetProjectCareersQuery.Companion.variablesSerializer,
  )


private class GetProjectScheduleByParticipantQueryImpl(
  connector: NexaConnector
):
  GetProjectScheduleByParticipantQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectScheduleByParticipantQuery.Data,
      GetProjectScheduleByParticipantQuery.Variables
  >(
    connector,
    GetProjectScheduleByParticipantQuery.Companion.operationName,
    GetProjectScheduleByParticipantQuery.Companion.dataDeserializer,
    GetProjectScheduleByParticipantQuery.Companion.variablesSerializer,
  )


private class GetProjectSchedulesQueryImpl(
  connector: NexaConnector
):
  GetProjectSchedulesQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectSchedulesQuery.Data,
      Unit
  >(
    connector,
    GetProjectSchedulesQuery.Companion.operationName,
    GetProjectSchedulesQuery.Companion.dataDeserializer,
    GetProjectSchedulesQuery.Companion.variablesSerializer,
  )


private class GetProjectTypeQueryImpl(
  connector: NexaConnector
):
  GetProjectTypeQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectTypeQuery.Data,
      Unit
  >(
    connector,
    GetProjectTypeQuery.Companion.operationName,
    GetProjectTypeQuery.Companion.dataDeserializer,
    GetProjectTypeQuery.Companion.variablesSerializer,
  )


private class GetProjectsQueryImpl(
  connector: NexaConnector
):
  GetProjectsQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectsQuery.Data,
      Unit
  >(
    connector,
    GetProjectsQuery.Companion.operationName,
    GetProjectsQuery.Companion.dataDeserializer,
    GetProjectsQuery.Companion.variablesSerializer,
  )


private class GetRoleByNameQueryImpl(
  connector: NexaConnector
):
  GetRoleByNameQuery,
  NexaConnectorGeneratedQueryImpl<
      GetRoleByNameQuery.Data,
      GetRoleByNameQuery.Variables
  >(
    connector,
    GetRoleByNameQuery.Companion.operationName,
    GetRoleByNameQuery.Companion.dataDeserializer,
    GetRoleByNameQuery.Companion.variablesSerializer,
  )


private class GetRolesQueryImpl(
  connector: NexaConnector
):
  GetRolesQuery,
  NexaConnectorGeneratedQueryImpl<
      GetRolesQuery.Data,
      Unit
  >(
    connector,
    GetRolesQuery.Companion.operationName,
    GetRolesQuery.Companion.dataDeserializer,
    GetRolesQuery.Companion.variablesSerializer,
  )


private class GetTodasActividadesQueryImpl(
  connector: NexaConnector
):
  GetTodasActividadesQuery,
  NexaConnectorGeneratedQueryImpl<
      GetTodasActividadesQuery.Data,
      GetTodasActividadesQuery.Variables
  >(
    connector,
    GetTodasActividadesQuery.Companion.operationName,
    GetTodasActividadesQuery.Companion.dataDeserializer,
    GetTodasActividadesQuery.Companion.variablesSerializer,
  )


private class GetUserByIdQueryImpl(
  connector: NexaConnector
):
  GetUserByIdQuery,
  NexaConnectorGeneratedQueryImpl<
      GetUserByIdQuery.Data,
      GetUserByIdQuery.Variables
  >(
    connector,
    GetUserByIdQuery.Companion.operationName,
    GetUserByIdQuery.Companion.dataDeserializer,
    GetUserByIdQuery.Companion.variablesSerializer,
  )


private class SeedParticipantsMutationImpl(
  connector: NexaConnector
):
  SeedParticipantsMutation,
  NexaConnectorGeneratedMutationImpl<
      SeedParticipantsMutation.Data,
      Unit
  >(
    connector,
    SeedParticipantsMutation.Companion.operationName,
    SeedParticipantsMutation.Companion.dataDeserializer,
    SeedParticipantsMutation.Companion.variablesSerializer,
  )


private class SeedProjectScheduleMutationImpl(
  connector: NexaConnector
):
  SeedProjectScheduleMutation,
  NexaConnectorGeneratedMutationImpl<
      SeedProjectScheduleMutation.Data,
      Unit
  >(
    connector,
    SeedProjectScheduleMutation.Companion.operationName,
    SeedProjectScheduleMutation.Companion.dataDeserializer,
    SeedProjectScheduleMutation.Companion.variablesSerializer,
  )


private class SeedProjectTypeMutationImpl(
  connector: NexaConnector
):
  SeedProjectTypeMutation,
  NexaConnectorGeneratedMutationImpl<
      SeedProjectTypeMutation.Data,
      Unit
  >(
    connector,
    SeedProjectTypeMutation.Companion.operationName,
    SeedProjectTypeMutation.Companion.dataDeserializer,
    SeedProjectTypeMutation.Companion.variablesSerializer,
  )


private class UpdateProjectScheduleMutationImpl(
  connector: NexaConnector
):
  UpdateProjectScheduleMutation,
  NexaConnectorGeneratedMutationImpl<
      UpdateProjectScheduleMutation.Data,
      UpdateProjectScheduleMutation.Variables
  >(
    connector,
    UpdateProjectScheduleMutation.Companion.operationName,
    UpdateProjectScheduleMutation.Companion.dataDeserializer,
    UpdateProjectScheduleMutation.Companion.variablesSerializer,
  )


