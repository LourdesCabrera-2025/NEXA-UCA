
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



public interface SeedProjectTypeMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      SeedProjectTypeMutation.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val servicio_interno: ProjectTypeKey,
  
    val servicio_externo: ProjectTypeKey,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "SeedProjectType"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun SeedProjectTypeMutation.ref(
  
): com.google.firebase.dataconnect.MutationRef<
    SeedProjectTypeMutation.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun SeedProjectTypeMutation.execute(

  

  ): com.google.firebase.dataconnect.MutationResult<
    SeedProjectTypeMutation.Data,
    Unit
  > =
  ref(
    
  ).execute()


