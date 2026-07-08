
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



public interface CreateActivityMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateActivityMutation.Data,
      CreateActivityMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val attendanceId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val title: String,
    val description: String
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val activity_insert: ActivityKey
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateActivity"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateActivityMutation.ref(
  
    attendanceId: java.util.UUID,title: String,description: String,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateActivityMutation.Data,
    CreateActivityMutation.Variables
  > =
  ref(
    
      CreateActivityMutation.Variables(
        attendanceId=attendanceId,title=title,description=description,
  
      )
    
  )

public suspend fun CreateActivityMutation.execute(

  
    
      attendanceId: java.util.UUID,title: String,description: String,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateActivityMutation.Data,
    CreateActivityMutation.Variables
  > =
  ref(
    
      attendanceId=attendanceId,title=title,description=description,
  
    
  ).execute()


