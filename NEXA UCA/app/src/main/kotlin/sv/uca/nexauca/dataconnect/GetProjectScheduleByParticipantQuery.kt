
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


public interface GetProjectScheduleByParticipantQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectScheduleByParticipantQuery.Data,
      GetProjectScheduleByParticipantQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedules: List<ProjectSchedulesItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectSchedulesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val dayOfWeek: Int,
  
    val startHour: String,
  
    val endHour: String,
  
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectScheduleByParticipant"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectScheduleByParticipantQuery.ref(
  
    participantId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectScheduleByParticipantQuery.Data,
    GetProjectScheduleByParticipantQuery.Variables
  > =
  ref(
    
      GetProjectScheduleByParticipantQuery.Variables(
        participantId=participantId,
  
      )
    
  )

public suspend fun GetProjectScheduleByParticipantQuery.execute(

  
    
      participantId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectScheduleByParticipantQuery.Data,
    GetProjectScheduleByParticipantQuery.Variables
  > =
  ref(
    
      participantId=participantId,
  
    
  ).execute()


  public fun GetProjectScheduleByParticipantQuery.flow(
    
      participantId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetProjectScheduleByParticipantQuery.Data> =
    ref(
        
          participantId=participantId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

