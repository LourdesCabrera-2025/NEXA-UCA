
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



public interface SeedProjectScheduleMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      SeedProjectScheduleMutation.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val marteManana: ProjectScheduleKey,
  
    val martesTarde: ProjectScheduleKey,
  
    val Miercoles: ProjectScheduleKey,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "SeedProjectSchedule"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun SeedProjectScheduleMutation.ref(
  
): com.google.firebase.dataconnect.MutationRef<
    SeedProjectScheduleMutation.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun SeedProjectScheduleMutation.execute(

  

  ): com.google.firebase.dataconnect.MutationResult<
    SeedProjectScheduleMutation.Data,
    Unit
  > =
  ref(
    
  ).execute()


