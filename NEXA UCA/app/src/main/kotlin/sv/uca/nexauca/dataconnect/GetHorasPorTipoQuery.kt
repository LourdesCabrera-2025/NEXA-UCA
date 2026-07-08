
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


public interface GetHorasPorTipoQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetHorasPorTipoQuery.Data,
      GetHorasPorTipoQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val uid: String,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val participants: List<ParticipantsItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ParticipantsItem(
  
    val accumulateHours: Double,
  
    val project: Project,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Project(
  
    val projectType: ProjectType,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectType(
  
    val name: String,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetHorasPorTipo"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetHorasPorTipoQuery.ref(
  
    uid: String,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetHorasPorTipoQuery.Data,
    GetHorasPorTipoQuery.Variables
  > =
  ref(
    
      GetHorasPorTipoQuery.Variables(
        uid=uid,
  
      )
    
  )

public suspend fun GetHorasPorTipoQuery.execute(

  
    
      uid: String,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetHorasPorTipoQuery.Data,
    GetHorasPorTipoQuery.Variables
  > =
  ref(
    
      uid=uid,
  
    
  ).execute()


  public fun GetHorasPorTipoQuery.flow(
    
      uid: String,

  
    
    ): kotlinx.coroutines.flow.Flow<GetHorasPorTipoQuery.Data> =
    ref(
        
          uid=uid,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

