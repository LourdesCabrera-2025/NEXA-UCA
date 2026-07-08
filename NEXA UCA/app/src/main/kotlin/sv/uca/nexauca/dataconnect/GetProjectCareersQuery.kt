
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


public interface GetProjectCareersQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectCareersQuery.Data,
      GetProjectCareersQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val projectId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectCareers: List<ProjectCareersItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectCareersItem(
  
    val career: Career,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Career(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val name: String,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectCareers"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectCareersQuery.ref(
  
    projectId: java.util.UUID,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectCareersQuery.Data,
    GetProjectCareersQuery.Variables
  > =
  ref(
    
      GetProjectCareersQuery.Variables(
        projectId=projectId,
  
      )
    
  )

public suspend fun GetProjectCareersQuery.execute(

  
    
      projectId: java.util.UUID,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectCareersQuery.Data,
    GetProjectCareersQuery.Variables
  > =
  ref(
    
      projectId=projectId,
  
    
  ).execute()


  public fun GetProjectCareersQuery.flow(
    
      projectId: java.util.UUID,

  
    
    ): kotlinx.coroutines.flow.Flow<GetProjectCareersQuery.Data> =
    ref(
        
          projectId=projectId,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

