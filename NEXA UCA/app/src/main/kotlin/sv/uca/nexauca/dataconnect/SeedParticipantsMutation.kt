
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



public interface SeedParticipantsMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      SeedParticipantsMutation.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val participante1: ParticipantKey,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "SeedParticipants"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun SeedParticipantsMutation.ref(
  
): com.google.firebase.dataconnect.MutationRef<
    SeedParticipantsMutation.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun SeedParticipantsMutation.execute(

  

  ): com.google.firebase.dataconnect.MutationResult<
    SeedParticipantsMutation.Data,
    Unit
  > =
  ref(
    
  ).execute()


