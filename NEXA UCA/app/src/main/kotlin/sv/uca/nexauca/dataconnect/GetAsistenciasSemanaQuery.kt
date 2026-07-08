
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


public interface GetAsistenciasSemanaQuery :
    com.google.firebase.dataconnect.generated.GeneratedQuery<
      NexaConnector,
      GetAsistenciasSemanaQuery.Data,
      GetAsistenciasSemanaQuery.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val uid: String,
  
    val inicioSemana: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
  
    val finSemana: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val attendances: List<AttendancesItem>,
  
  ) {
    
      
        @kotlinx.serialization.Serializable
  public data class AttendancesItem(
  
    val checkIn: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp,
  
    val checkOut: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.TimestampSerializer::class) com.google.firebase.Timestamp?,
  
  ) {
    
    
  }
      
    
    
  }
  

  public companion object {
    public val operationName: String = "GetAsistenciasSemana"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun GetAsistenciasSemanaQuery.ref(
  
    uid: String,inicioSemana: com.google.firebase.Timestamp,finSemana: com.google.firebase.Timestamp,

  
  
): com.google.firebase.dataconnect.QueryRef<
    GetAsistenciasSemanaQuery.Data,
    GetAsistenciasSemanaQuery.Variables
  > =
  ref(
    
      GetAsistenciasSemanaQuery.Variables(
        uid=uid,inicioSemana=inicioSemana,finSemana=finSemana,
  
      )
    
  )

public suspend fun GetAsistenciasSemanaQuery.execute(

  
    
      uid: String,inicioSemana: com.google.firebase.Timestamp,finSemana: com.google.firebase.Timestamp,

  

  ): com.google.firebase.dataconnect.QueryResult<
    GetAsistenciasSemanaQuery.Data,
    GetAsistenciasSemanaQuery.Variables
  > =
  ref(
    
      uid=uid,inicioSemana=inicioSemana,finSemana=finSemana,
  
    
  ).execute()


  public fun GetAsistenciasSemanaQuery.flow(
    
      uid: String,inicioSemana: com.google.firebase.Timestamp,finSemana: com.google.firebase.Timestamp,

  
    
    ): kotlinx.coroutines.flow.Flow<GetAsistenciasSemanaQuery.Data> =
    ref(
        
          uid=uid,inicioSemana=inicioSemana,finSemana=finSemana,
  
        
      ).subscribe()
      .flow
      ._flow_map { querySubscriptionResult -> querySubscriptionResult.result.getOrNull() }
      ._flow_filterNotNull()
      ._flow_map { it.data }

