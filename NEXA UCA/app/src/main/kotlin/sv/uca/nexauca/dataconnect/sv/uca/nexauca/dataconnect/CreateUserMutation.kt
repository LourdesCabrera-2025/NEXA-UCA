
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



public interface CreateUserMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateUserMutation.Data,
      CreateUserMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: String,
    val email: String,
    val fullName: String,
    val photoUrl: String,
    val roleId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val user_insert: UserKey
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateUser"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateUserMutation.ref(
  
    id: String,email: String,fullName: String,photoUrl: String,roleId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateUserMutation.Data,
    CreateUserMutation.Variables
  > =
  ref(
    
      CreateUserMutation.Variables(
        id=id,email=email,fullName=fullName,photoUrl=photoUrl,roleId=roleId,
  
      )
    
  )

public suspend fun CreateUserMutation.execute(

  
    
      id: String,email: String,fullName: String,photoUrl: String,roleId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateUserMutation.Data,
    CreateUserMutation.Variables
  > =
  ref(
    
      id=id,email=email,fullName=fullName,photoUrl=photoUrl,roleId=roleId,
  
    
  ).execute()


