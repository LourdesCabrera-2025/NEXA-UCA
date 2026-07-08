
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


import kotlinx.coroutines.flow.filterNotNull as _flow_filterNotNull
import kotlinx.coroutines.flow.map as _flow_map


public interface GetProjectByIdQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectByIdQuery.Data,
      GetProjectByIdQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val project: Project?,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Project(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val name: String,
  
    val description: String?,
  
    val projectType: ProjectType,
  
    val supervisor: Supervisor,
  
    val startDate: com.google.firebase.dataconnect.LocalDate,
  
    val endDate: com.google.firebase.dataconnect.LocalDate,
  
    val latitude: Double,
  
    val longitude: Double,
  
    val allowedRadius: Double,
  
    val maxStudents: Int,
  
    val maxHoursPerDay: Int,
  
    val totalRequiredHours: Int,
  
    val isActive: Boolean,
  
    val createdAt: com.google.firebase.dataconnect.LocalDate,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectType(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val name: String,
  
  ) {
    
    
  }
      
        @kotlinx.serialization.Serializable
  public data class Supervisor(
  
    val id: String,
  
    val fullName: String,
  
    val email: String,
  
    val photoUrl: String?,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectById"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectByIdQuery.ref(
  
    id: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectByIdQuery.Data,
    GetProjectByIdQuery.Variables
  > =
  ref(
    
      GetProjectByIdQuery.Variables(
        id=id,
  
      )
    
  )

public suspend fun GetProjectByIdQuery.execute(

  
    
      id: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectByIdQuery.Data,
    GetProjectByIdQuery.Variables
  > =
  ref(
    
      id=id,
  
    
  ).execute()


  public fun GetProjectByIdQuery.flow(
    
      id: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetProjectByIdQuery.Data> =
    ref(
        
          id=id,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

