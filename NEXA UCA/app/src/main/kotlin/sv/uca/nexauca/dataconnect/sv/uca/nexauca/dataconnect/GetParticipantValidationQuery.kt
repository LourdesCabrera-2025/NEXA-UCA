
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


import java.util.UUID
import kotlinx.coroutines.flow.filterNotNull as _flow_filterNotNull
import kotlinx.coroutines.flow.map as _flow_map


public interface GetParticipantValidationQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetParticipantValidationQuery.Data,
      GetParticipantValidationQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(

    val studentId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val participants: List<ParticipantsItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ParticipantsItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val status: String,
    val accumulateHours: Double,
    val project: Project
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Project(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String,
    val latitude: Double,
    val longitude: Double,
    val allowedRadius: Double,
    val maxHoursPerDay: Int,
    val totalRequiredHours: Int,
    val isActive: Boolean
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetParticipantValidation"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetParticipantValidationQuery.ref(

    studentId: java.util.UUID,



): com.google.firebase.dataconnect.QueryRef<
    GetParticipantValidationQuery.Data,
    GetParticipantValidationQuery.Variables
  > =
  ref(
    
      GetParticipantValidationQuery.Variables(
        studentId=studentId,
  
      )
    
  )

public suspend fun GetParticipantValidationQuery.execute(


    studentId: UUID,



    ): com.google.firebase.dataconnect.QueryResult<
    GetParticipantValidationQuery.Data,
    GetParticipantValidationQuery.Variables
  > =
  ref(

      studentId=studentId,
  
    
  ).execute()


  public fun GetParticipantValidationQuery.flow(
    
      studentId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetParticipantValidationQuery.Data> =
    ref(

          studentId=studentId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

