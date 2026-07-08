
@file:Suppress(
  "KotlinRedundantDiagnosticSuppress",
  "LocalVariableName",
  "MayBeConstant",
  "RedundantVisibilityModifier",
  "RedundantCompanionReference",
  "RemoveEmptyClassBody",
  "SpellCheckingInspection",
  "LocalVariableName",
  "unused",
)

package sv.uca.nexauca.dataconnect

import com.google.firebase.dataconnect.getInstance as _fdcGetInstance
import kotlin.time.Duration.Companion.milliseconds as _milliseconds

public interface NexaConnector : com.google.firebase.dataconnect.generated.GeneratedConnector<NexaConnector> {
  override val dataConnect: com.google.firebase.dataconnect.FirebaseDataConnect

  
    public val createActivity: CreateActivityMutation
  
    public val createAttendance: CreateAttendanceMutation
  
    public val createProject: CreateProjectMutation
  
    public val createStudent: CreateStudentMutation
  
    public val createUser: CreateUserMutation
  
    public val getActiveAttendance: GetActiveAttendanceQuery
  
    public val getActivityByAttendance: GetActivityByAttendanceQuery
  
    public val getCareers: GetCareersQuery
  
    public val getDepartment: GetDepartmentQuery
  
    public val getMyStudent: GetMyStudentQuery
  
    public val getParticipantValidation: GetParticipantValidationQuery
  
    public val getProjectSchedules: GetProjectSchedulesQuery
  
    public val getProjectType: GetProjectTypeQuery
  
    public val getRoleByName: GetRoleByNameQuery
  
    public val getRoles: GetRolesQuery
  
    public val getUserById: GetUserByIdQuery
  
    public val seedProjectType: SeedProjectTypeMutation
  
    public val updateActivity: UpdateActivityMutation
  
    public val updateAttendanceCheckOut: UpdateAttendanceCheckOutMutation
  
    public val updateAttendanceStatus: UpdateAttendanceStatusMutation
  

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
  
    override val createActivity by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateActivityMutationImpl(this)
    }
  
    override val createAttendance by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateAttendanceMutationImpl(this)
    }
  
    override val createProject by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateProjectMutationImpl(this)
    }
  
    override val createStudent by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateStudentMutationImpl(this)
    }
  
    override val createUser by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateUserMutationImpl(this)
    }
  
    override val getActiveAttendance by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetActiveAttendanceQueryImpl(this)
    }
  
    override val getActivityByAttendance by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetActivityByAttendanceQueryImpl(this)
    }
  
    override val getCareers by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetCareersQueryImpl(this)
    }
  
    override val getDepartment by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetDepartmentQueryImpl(this)
    }
  
    override val getMyStudent by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetMyStudentQueryImpl(this)
    }
  
    override val getParticipantValidation by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetParticipantValidationQueryImpl(this)
    }
  
    override val getProjectSchedules by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectSchedulesQueryImpl(this)
    }
  
    override val getProjectType by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetProjectTypeQueryImpl(this)
    }
  
    override val getRoleByName by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetRoleByNameQueryImpl(this)
    }
  
    override val getRoles by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetRolesQueryImpl(this)
    }
  
    override val getUserById by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetUserByIdQueryImpl(this)
    }
  
    override val seedProjectType by lazy(LazyThreadSafetyMode.PUBLICATION) {
      SeedProjectTypeMutationImpl(this)
    }
  
    override val updateActivity by lazy(LazyThreadSafetyMode.PUBLICATION) {
      UpdateActivityMutationImpl(this)
    }
  
    override val updateAttendanceCheckOut by lazy(LazyThreadSafetyMode.PUBLICATION) {
      UpdateAttendanceCheckOutMutationImpl(this)
    }
  
    override val updateAttendanceStatus by lazy(LazyThreadSafetyMode.PUBLICATION) {
      UpdateAttendanceStatusMutationImpl(this)
    }
  

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun operations(): List<com.google.firebase.dataconnect.generated.GeneratedOperation<NexaConnector, *, *>> =
    queries() + mutations()

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun mutations(): List<com.google.firebase.dataconnect.generated.GeneratedMutation<NexaConnector, *, *>> =
    listOf(
      createActivity,
        createAttendance,
        createProject,
        createStudent,
        createUser,
        seedProjectType,
        updateActivity,
        updateAttendanceCheckOut,
        updateAttendanceStatus,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun queries(): List<com.google.firebase.dataconnect.generated.GeneratedQuery<NexaConnector, *, *>> =
    listOf(
      getActiveAttendance,
        getActivityByAttendance,
        getCareers,
        getDepartment,
        getMyStudent,
        getParticipantValidation,
        getProjectSchedules,
        getProjectType,
        getRoleByName,
        getRoles,
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



private class CreateActivityMutationImpl(
  connector: NexaConnector
):
  CreateActivityMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateActivityMutation.Data,
      CreateActivityMutation.Variables
  >(
    connector,
    CreateActivityMutation.Companion.operationName,
    CreateActivityMutation.Companion.dataDeserializer,
    CreateActivityMutation.Companion.variablesSerializer,
  )


private class CreateAttendanceMutationImpl(
  connector: NexaConnector
):
  CreateAttendanceMutation,
  NexaConnectorGeneratedMutationImpl<
      CreateAttendanceMutation.Data,
      CreateAttendanceMutation.Variables
  >(
    connector,
    CreateAttendanceMutation.Companion.operationName,
    CreateAttendanceMutation.Companion.dataDeserializer,
    CreateAttendanceMutation.Companion.variablesSerializer,
  )


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


private class GetActiveAttendanceQueryImpl(
  connector: NexaConnector
):
  GetActiveAttendanceQuery,
  NexaConnectorGeneratedQueryImpl<
      GetActiveAttendanceQuery.Data,
      GetActiveAttendanceQuery.Variables
  >(
    connector,
    GetActiveAttendanceQuery.Companion.operationName,
    GetActiveAttendanceQuery.Companion.dataDeserializer,
    GetActiveAttendanceQuery.Companion.variablesSerializer,
  )


private class GetActivityByAttendanceQueryImpl(
  connector: NexaConnector
):
  GetActivityByAttendanceQuery,
  NexaConnectorGeneratedQueryImpl<
      GetActivityByAttendanceQuery.Data,
      GetActivityByAttendanceQuery.Variables
  >(
    connector,
    GetActivityByAttendanceQuery.Companion.operationName,
    GetActivityByAttendanceQuery.Companion.dataDeserializer,
    GetActivityByAttendanceQuery.Companion.variablesSerializer,
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


private class GetParticipantValidationQueryImpl(
  connector: NexaConnector
):
  GetParticipantValidationQuery,
  NexaConnectorGeneratedQueryImpl<
      GetParticipantValidationQuery.Data,
      GetParticipantValidationQuery.Variables
  >(
    connector,
    GetParticipantValidationQuery.Companion.operationName,
    GetParticipantValidationQuery.Companion.dataDeserializer,
    GetParticipantValidationQuery.Companion.variablesSerializer,
  )


private class GetProjectSchedulesQueryImpl(
  connector: NexaConnector
):
  GetProjectSchedulesQuery,
  NexaConnectorGeneratedQueryImpl<
      GetProjectSchedulesQuery.Data,
      GetProjectSchedulesQuery.Variables
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


private class UpdateActivityMutationImpl(
  connector: NexaConnector
):
  UpdateActivityMutation,
  NexaConnectorGeneratedMutationImpl<
      UpdateActivityMutation.Data,
      UpdateActivityMutation.Variables
  >(
    connector,
    UpdateActivityMutation.Companion.operationName,
    UpdateActivityMutation.Companion.dataDeserializer,
    UpdateActivityMutation.Companion.variablesSerializer,
  )


private class UpdateAttendanceCheckOutMutationImpl(
  connector: NexaConnector
):
  UpdateAttendanceCheckOutMutation,
  NexaConnectorGeneratedMutationImpl<
      UpdateAttendanceCheckOutMutation.Data,
      UpdateAttendanceCheckOutMutation.Variables
  >(
    connector,
    UpdateAttendanceCheckOutMutation.Companion.operationName,
    UpdateAttendanceCheckOutMutation.Companion.dataDeserializer,
    UpdateAttendanceCheckOutMutation.Companion.variablesSerializer,
  )


private class UpdateAttendanceStatusMutationImpl(
  connector: NexaConnector
):
  UpdateAttendanceStatusMutation,
  NexaConnectorGeneratedMutationImpl<
      UpdateAttendanceStatusMutation.Data,
      UpdateAttendanceStatusMutation.Variables
  >(
    connector,
    UpdateAttendanceStatusMutation.Companion.operationName,
    UpdateAttendanceStatusMutation.Companion.dataDeserializer,
    UpdateAttendanceStatusMutation.Companion.variablesSerializer,
  )


