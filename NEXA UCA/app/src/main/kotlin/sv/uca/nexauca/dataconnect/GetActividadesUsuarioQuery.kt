
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


import kotlinx.coroutines.flow.filterNotNull as _flow_filterNotNull
import kotlinx.coroutines.flow.map as _flow_map


public interface GetActividadesUsuarioQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetActividadesUsuarioQuery.Data,
      GetActividadesUsuarioQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val uid: String,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val activities: List<ActivitiesItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ActivitiesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val approved: Boolean,
  
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetActividadesUsuario"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetActividadesUsuarioQuery.ref(
  
    uid: String,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetActividadesUsuarioQuery.Data,
    GetActividadesUsuarioQuery.Variables
  > =
  ref(
    
      GetActividadesUsuarioQuery.Variables(
        uid=uid,
  
      )
    
  )

public suspend fun GetActividadesUsuarioQuery.execute(

  
    
      uid: String,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetActividadesUsuarioQuery.Data,
    GetActividadesUsuarioQuery.Variables
  > =
  ref(
    
      uid=uid,
  
    
  ).execute()


  public fun GetActividadesUsuarioQuery.flow(
    
      uid: String,

  
    
    ): kotlinx.coroutines.flow.Flow<GetActividadesUsuarioQuery.Data> =
    ref(
        
          uid=uid,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

