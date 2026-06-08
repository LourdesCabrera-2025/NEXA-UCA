
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


public interface GetCareersQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetCareersQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val careers: List<CareersItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class CareersItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String,
    val department: Department
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Department(
  
    val name: String
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetCareers"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetCareersQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetCareersQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetCareersQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetCareersQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetCareersQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetCareersQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

