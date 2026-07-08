
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



public interface UpdateAttendanceCheckOutMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      UpdateAttendanceCheckOutMutation.Data,
      UpdateAttendanceCheckOutMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val checkOut: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val attendance_update: AttendanceKey?
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "UpdateAttendanceCheckOut"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun UpdateAttendanceCheckOutMutation.ref(
  
    id: java.util.UUID,checkOut: com.google.firebase.Timestamp,

  
  
): com.google.firebase.dataconnect.MutationRef<
    UpdateAttendanceCheckOutMutation.Data,
    UpdateAttendanceCheckOutMutation.Variables
  > =
  ref(
    
      UpdateAttendanceCheckOutMutation.Variables(
        id=id,checkOut=checkOut,
  
      )
    
  )

public suspend fun UpdateAttendanceCheckOutMutation.execute(

  
    
      id: java.util.UUID,checkOut: com.google.firebase.Timestamp,

  

  ): com.google.firebase.dataconnect.MutationResult<
    UpdateAttendanceCheckOutMutation.Data,
    UpdateAttendanceCheckOutMutation.Variables
  > =
  ref(
    
      id=id,checkOut=checkOut,
  
    
  ).execute()


