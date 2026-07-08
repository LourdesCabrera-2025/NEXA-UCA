
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



public interface CreateAttendanceMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateAttendanceMutation.Data,
      CreateAttendanceMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val checkIn: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
    val latitude: Double,
    val longitude: Double,
    val status: String
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val attendance_insert: AttendanceKey
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateAttendance"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateAttendanceMutation.ref(
  
    participantId: java.util.UUID,checkIn: com.google.firebase.Timestamp,latitude: Double,longitude: Double,status: String,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateAttendanceMutation.Data,
    CreateAttendanceMutation.Variables
  > =
  ref(
    
      CreateAttendanceMutation.Variables(
        participantId=participantId,checkIn=checkIn,latitude=latitude,longitude=longitude,status=status,
  
      )
    
  )

public suspend fun CreateAttendanceMutation.execute(

  
    
      participantId: java.util.UUID,checkIn: com.google.firebase.Timestamp,latitude: Double,longitude: Double,status: String,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateAttendanceMutation.Data,
    CreateAttendanceMutation.Variables
  > =
  ref(
    
      participantId=participantId,checkIn=checkIn,latitude=latitude,longitude=longitude,status=status,
  
    
  ).execute()


