
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



public interface UpdateAttendanceStatusMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      UpdateAttendanceStatusMutation.Data,
      UpdateAttendanceStatusMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val status: String
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val attendance_update: AttendanceKey?
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "UpdateAttendanceStatus"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun UpdateAttendanceStatusMutation.ref(
  
    id: java.util.UUID,status: String,

  
  
): com.google.firebase.dataconnect.MutationRef<
    UpdateAttendanceStatusMutation.Data,
    UpdateAttendanceStatusMutation.Variables
  > =
  ref(
    
      UpdateAttendanceStatusMutation.Variables(
        id=id,status=status,
  
      )
    
  )

public suspend fun UpdateAttendanceStatusMutation.execute(

  
    
      id: java.util.UUID,status: String,

  

  ): com.google.firebase.dataconnect.MutationResult<
    UpdateAttendanceStatusMutation.Data,
    UpdateAttendanceStatusMutation.Variables
  > =
  ref(
    
      id=id,status=status,
  
    
  ).execute()


