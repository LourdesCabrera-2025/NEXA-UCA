
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


public interface GetProjectsQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectsQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projects: List<ProjectsItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectsItem(
  
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
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjects"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectsQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectsQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetProjectsQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectsQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetProjectsQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetProjectsQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

