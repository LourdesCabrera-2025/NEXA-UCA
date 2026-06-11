
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


public interface GetRoleByNameQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetRoleByNameQuery.Data,
      GetRoleByNameQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val name: String
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val roles: List<RolesItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class RolesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetRoleByName"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetRoleByNameQuery.ref(
  
    name: String,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetRoleByNameQuery.Data,
    GetRoleByNameQuery.Variables
  > =
  ref(
    
      GetRoleByNameQuery.Variables(
        name=name,
  
      )
    
  )

public suspend fun GetRoleByNameQuery.execute(

  
    
      name: String,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetRoleByNameQuery.Data,
    GetRoleByNameQuery.Variables
  > =
  ref(
    
      name=name,
  
    
  ).execute()


  public fun GetRoleByNameQuery.flow(
    
      name: String,

  
    
    ): kotlinx.coroutines.flow.Flow<GetRoleByNameQuery.Data> =
    ref(
        
          name=name,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

