
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

  
    public val createStudent: CreateStudentMutation
  
    public val createUser: CreateUserMutation
  
    public val getCareers: GetCareersQuery
  
    public val getDepartment: GetDepartmentQuery
  
    public val getUserById: GetUserByIdQuery
  

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
  
    override val createStudent by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateStudentMutationImpl(this)
    }
  
    override val createUser by lazy(LazyThreadSafetyMode.PUBLICATION) {
      CreateUserMutationImpl(this)
    }
  
    override val getCareers by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetCareersQueryImpl(this)
    }
  
    override val getDepartment by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetDepartmentQueryImpl(this)
    }
  
    override val getUserById by lazy(LazyThreadSafetyMode.PUBLICATION) {
      GetUserByIdQueryImpl(this)
    }
  

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun operations(): List<com.google.firebase.dataconnect.generated.GeneratedOperation<NexaConnector, *, *>> =
    queries() + mutations()

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun mutations(): List<com.google.firebase.dataconnect.generated.GeneratedMutation<NexaConnector, *, *>> =
    listOf(
      createStudent,
        createUser,
        
    )

  @com.google.firebase.dataconnect.ExperimentalFirebaseDataConnect
  override fun queries(): List<com.google.firebase.dataconnect.generated.GeneratedQuery<NexaConnector, *, *>> =
    listOf(
      getCareers,
        getDepartment,
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


