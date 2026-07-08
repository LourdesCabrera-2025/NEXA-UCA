
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


public interface GetProjectSchedulesQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetProjectSchedulesQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedules: List<ProjectSchedulesItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectSchedulesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val dayOfWeek: Int,
  
    val startHour: String,
  
    val endHour: String,
  
    val participant: Participant,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Participant(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val student: Student,
  
    val project: Project,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Student(
  
    val studentCode: String,
  
    val user: User,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class User(
  
    val id: String,
  
    val fullName: String,
  
    val email: String,
  
  ) {
    
    
  }
      
    
    
  }
      
        @kotlinx.serialization.Serializable
  public data class Project(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val name: String,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetProjectSchedules"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetProjectSchedulesQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetProjectSchedulesQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetProjectSchedulesQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetProjectSchedulesQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetProjectSchedulesQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetProjectSchedulesQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

