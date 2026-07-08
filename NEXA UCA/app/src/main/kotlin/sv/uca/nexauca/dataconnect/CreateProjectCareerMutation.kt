
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



public interface CreateProjectCareerMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateProjectCareerMutation.Data,
      CreateProjectCareerMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val projectId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val careerId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectCareer_insert: ProjectCareerKey,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateProjectCareer"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateProjectCareerMutation.ref(
  
    projectId: java.util.UUID,careerId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateProjectCareerMutation.Data,
    CreateProjectCareerMutation.Variables
  > =
  ref(
    
      CreateProjectCareerMutation.Variables(
        projectId=projectId,careerId=careerId,
  
      )
    
  )

public suspend fun CreateProjectCareerMutation.execute(

  
    
      projectId: java.util.UUID,careerId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateProjectCareerMutation.Data,
    CreateProjectCareerMutation.Variables
  > =
  ref(
    
      projectId=projectId,careerId=careerId,
  
    
  ).execute()


