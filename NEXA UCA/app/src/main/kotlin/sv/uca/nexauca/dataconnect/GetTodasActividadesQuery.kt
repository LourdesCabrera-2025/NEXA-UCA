
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


public interface GetTodasActividadesQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetTodasActividadesQuery.Data,
      GetTodasActividadesQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val uid: String,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val activities: List<ActivitiesItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ActivitiesItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val title: String,
  
    val approved: Boolean,
  
    val createdAt: com.google.firebase.dataconnect.LocalDate,
  
    val attendance: Attendance,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Attendance(
  
    val checkIn: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
  
    val checkOut: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp?,
  
    val participant: Participant,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Participant(
  
    val project: Project,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class Project(
  
    val name: String,
  
    val projectType: ProjectType,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class ProjectType(
  
    val name: String,
  
  ) {
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetTodasActividades"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetTodasActividadesQuery.ref(
  
    uid: String,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetTodasActividadesQuery.Data,
    GetTodasActividadesQuery.Variables
  > =
  ref(
    
      GetTodasActividadesQuery.Variables(
        uid=uid,
  
      )
    
  )

public suspend fun GetTodasActividadesQuery.execute(

  
    
      uid: String,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetTodasActividadesQuery.Data,
    GetTodasActividadesQuery.Variables
  > =
  ref(
    
      uid=uid,
  
    
  ).execute()


  public fun GetTodasActividadesQuery.flow(
    
      uid: String,

  
    
    ): kotlinx.coroutines.flow.Flow<GetTodasActividadesQuery.Data> =
    ref(
        
          uid=uid,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

