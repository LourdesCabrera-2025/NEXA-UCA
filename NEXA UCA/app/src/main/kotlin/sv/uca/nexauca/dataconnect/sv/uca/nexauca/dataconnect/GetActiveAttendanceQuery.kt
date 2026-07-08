
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


public interface GetActiveAttendanceQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetActiveAttendanceQuery.Data,
      GetActiveAttendanceQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val attendances: List<AttendancesItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class AttendancesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val checkIn: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
    val checkOut: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp?,
    val latitude: Double,
    val longitude: Double,
    val status: String
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetActiveAttendance"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetActiveAttendanceQuery.ref(
  
    participantId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetActiveAttendanceQuery.Data,
    GetActiveAttendanceQuery.Variables
  > =
  ref(
    
      GetActiveAttendanceQuery.Variables(
        participantId=participantId,
  
      )
    
  )

public suspend fun GetActiveAttendanceQuery.execute(

  
    
      participantId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetActiveAttendanceQuery.Data,
    GetActiveAttendanceQuery.Variables
  > =
  ref(
    
      participantId=participantId,
  
    
  ).execute()


  public fun GetActiveAttendanceQuery.flow(
    
      participantId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetActiveAttendanceQuery.Data> =
    ref(
        
          participantId=participantId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

