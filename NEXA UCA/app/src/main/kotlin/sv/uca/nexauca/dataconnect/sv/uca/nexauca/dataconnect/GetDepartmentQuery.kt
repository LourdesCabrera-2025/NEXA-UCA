
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


public interface GetDepartmentQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetDepartmentQuery.Data,
      Unit
    >
{
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val departments: List<DepartmentsItem>
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class DepartmentsItem(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val name: String
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetDepartment"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Unit> =
      kotlinx.serialization.serializer()
  }
}

public fun GetDepartmentQuery.ref(
  
): com.google.firebase.dataconnect.QueryRef<
    GetDepartmentQuery.Data,
    Unit
  > =
  ref(
    
      Unit
    
  )

public suspend fun GetDepartmentQuery.execute(

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetDepartmentQuery.Data,
    Unit
  > =
  ref(
    
  ).execute()


  public fun GetDepartmentQuery.flow(
    
    ): kotlinx.coroutines.flow.Flow<GetDepartmentQuery.Data> =
    ref(
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

