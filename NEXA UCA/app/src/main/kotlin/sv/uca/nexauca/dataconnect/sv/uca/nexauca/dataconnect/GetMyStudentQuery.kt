
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


import kotlinx.coroutines.flow.filterNotNull as _flow_filterNotNull
import kotlinx.coroutines.flow.map as _flow_map


public interface GetMyStudentQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetMyStudentQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val students: List<StudentsItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class StudentsItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val studentCode: String,
    val phoneNumber: String?,
    val user: User,
    val career: Career?
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class User(
  
    val id: String,
    val email: String,
    val fullName: String,
    val photoUrl: String?,
    val isActive: Boolean,
    val role: Role
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Role(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String
  ) {
    
    
  }
      
    
    
  }
      
        @kotlinx.serialization.Serializable
  public data class Career(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String,
    val department: Department
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Department(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetMyStudent"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetMyStudentQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetMyStudentQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetMyStudentQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetMyStudentQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetMyStudentQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetMyStudentQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

