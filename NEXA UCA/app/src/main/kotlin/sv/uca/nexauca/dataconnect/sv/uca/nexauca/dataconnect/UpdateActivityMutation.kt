
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



public interface UpdateActivityMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      UpdateActivityMutation.Data,
      UpdateActivityMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val approved: Boolean
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val activity_update: ActivityKey?
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "UpdateActivity"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun UpdateActivityMutation.ref(
  
    id: java.util.UUID,approved: Boolean,

  
  
): com.google.firebase.dataconnect.MutationRef<
    UpdateActivityMutation.Data,
    UpdateActivityMutation.Variables
  > =
  ref(
    
      UpdateActivityMutation.Variables(
        id=id,approved=approved,
  
      )
    
  )

public suspend fun UpdateActivityMutation.execute(

  
    
      id: java.util.UUID,approved: Boolean,

  

  ): com.google.firebase.dataconnect.MutationResult<
    UpdateActivityMutation.Data,
    UpdateActivityMutation.Variables
  > =
  ref(
    
      id=id,approved=approved,
  
    
  ).execute()


