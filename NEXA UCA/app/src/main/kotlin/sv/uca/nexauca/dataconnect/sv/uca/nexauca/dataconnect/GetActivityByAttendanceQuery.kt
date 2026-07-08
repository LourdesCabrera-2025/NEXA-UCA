
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


public interface GetActivityByAttendanceQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetActivityByAttendanceQuery.Data,
      GetActivityByAttendanceQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val attendanceId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val activities: List<ActivitiesItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ActivitiesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val attendanceId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val title: String,
    val description: String,
    val approved: Boolean,
    val createdAt: com.google.firebase.dataconnect.LocalDate
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetActivityByAttendance"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetActivityByAttendanceQuery.ref(
  
    attendanceId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetActivityByAttendanceQuery.Data,
    GetActivityByAttendanceQuery.Variables
  > =
  ref(
    
      GetActivityByAttendanceQuery.Variables(
        attendanceId=attendanceId,
  
      )
    
  )

public suspend fun GetActivityByAttendanceQuery.execute(

  
    
      attendanceId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetActivityByAttendanceQuery.Data,
    GetActivityByAttendanceQuery.Variables
  > =
  ref(
    
      attendanceId=attendanceId,
  
    
  ).execute()


  public fun GetActivityByAttendanceQuery.flow(
    
      attendanceId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetActivityByAttendanceQuery.Data> =
    ref(
        
          attendanceId=attendanceId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

