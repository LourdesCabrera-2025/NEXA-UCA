
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



public interface CreateProjectScheduleMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateProjectScheduleMutation.Data,
      CreateProjectScheduleMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val participantId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val dayOfWeek: Int,
  
    val startHour: String,
  
    val endHour: String,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedule_insert: ProjectScheduleKey,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateProjectSchedule"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateProjectScheduleMutation.ref(
  
    participantId: java.util.UUID,dayOfWeek: Int,startHour: String,endHour: String,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateProjectScheduleMutation.Data,
    CreateProjectScheduleMutation.Variables
  > =
  ref(
    
      CreateProjectScheduleMutation.Variables(
        participantId=participantId,dayOfWeek=dayOfWeek,startHour=startHour,endHour=endHour,
  
      )
    
  )

public suspend fun CreateProjectScheduleMutation.execute(

  
    
      participantId: java.util.UUID,dayOfWeek: Int,startHour: String,endHour: String,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateProjectScheduleMutation.Data,
    CreateProjectScheduleMutation.Variables
  > =
  ref(
    
      participantId=participantId,dayOfWeek=dayOfWeek,startHour=startHour,endHour=endHour,
  
    
  ).execute()


