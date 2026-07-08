
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



public interface DeleteProjectScheduleMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      DeleteProjectScheduleMutation.Data,
      DeleteProjectScheduleMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedule_delete: ProjectScheduleKey?,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "DeleteProjectSchedule"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun DeleteProjectScheduleMutation.ref(
  
    id: java.util.UUID,

  
  
): com.google.firebase.dataconnect.MutationRef<
    DeleteProjectScheduleMutation.Data,
    DeleteProjectScheduleMutation.Variables
  > =
  ref(
    
      DeleteProjectScheduleMutation.Variables(
        id=id,
  
      )
    
  )

public suspend fun DeleteProjectScheduleMutation.execute(

  
    
      id: java.util.UUID,

  

  ): com.google.firebase.dataconnect.MutationResult<
    DeleteProjectScheduleMutation.Data,
    DeleteProjectScheduleMutation.Variables
  > =
  ref(
    
      id=id,
  
    
  ).execute()


