
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


import kotlinx.coroutines.flow.filterNotNull as _flow_filterNotNull
import kotlinx.coroutines.flow.map as _flow_map


public interface GetProjectTypeQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectTypeQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectTypes: List<ProjectTypesItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectTypesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectType"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectTypeQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectTypeQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetProjectTypeQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectTypeQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetProjectTypeQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetProjectTypeQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

