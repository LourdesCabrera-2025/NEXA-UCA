
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


public interface GetProjectSchedulesQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectSchedulesQuery.Data,
      GetProjectSchedulesQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedules: List<ProjectSchedulesItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectSchedulesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val dayOfWeek: Int,
    val startHour: String,
    val endHour: String
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectSchedules"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectSchedulesQuery.ref(
  
    participantId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectSchedulesQuery.Data,
    GetProjectSchedulesQuery.Variables
  > =
  ref(
    
      GetProjectSchedulesQuery.Variables(
        participantId=participantId,
  
      )
    
  )

public suspend fun GetProjectSchedulesQuery.execute(

  
    
      participantId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectSchedulesQuery.Data,
    GetProjectSchedulesQuery.Variables
  > =
  ref(
    
      participantId=participantId,
  
    
  ).execute()


  public fun GetProjectSchedulesQuery.flow(
    
      participantId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetProjectSchedulesQuery.Data> =
    ref(
        
          participantId=participantId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

