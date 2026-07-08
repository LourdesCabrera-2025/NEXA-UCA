
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


public interface GetParticipantsByProjectQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetParticipantsByProjectQuery.Data,
      GetParticipantsByProjectQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val projectId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val participants: List<ParticipantsItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ParticipantsItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val status: String,
  
    val accumulateHours: Double,
  
    val student: Student,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Student(
  
    val studentCode: String,
  
    val career: Career?,
  
    val user: User,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Career(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val name: String,
  
  ) {
    
    
  }
      
        @kotlinx.serialization.Serializable
  public data class User(
  
    val fullName: String,
  
    val email: String,
  
    val photoUrl: String?,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetParticipantsByProject"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetParticipantsByProjectQuery.ref(
  
    projectId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetParticipantsByProjectQuery.Data,
    GetParticipantsByProjectQuery.Variables
  > =
  ref(
    
      GetParticipantsByProjectQuery.Variables(
        projectId=projectId,
  
      )
    
  )

public suspend fun GetParticipantsByProjectQuery.execute(

  
    
      projectId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetParticipantsByProjectQuery.Data,
    GetParticipantsByProjectQuery.Variables
  > =
  ref(
    
      projectId=projectId,
  
    
  ).execute()


  public fun GetParticipantsByProjectQuery.flow(
    
      projectId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetParticipantsByProjectQuery.Data> =
    ref(
        
          projectId=projectId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

