
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



public interface UpdateProjectScheduleMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      UpdateProjectScheduleMutation.Data,
      UpdateProjectScheduleMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val id: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
  
    val dayOfWeek: Int,
  
    val startHour: String,
  
    val endHour: String,
  
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val projectSchedule_update: ProjectScheduleKey?,
  
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "UpdateProjectSchedule"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun UpdateProjectScheduleMutation.ref(
  
    id: java.util.UUID,dayOfWeek: Int,startHour: String,endHour: String,

  
  
): com.google.firebase.dataconnect.MutationRef<
    UpdateProjectScheduleMutation.Data,
    UpdateProjectScheduleMutation.Variables
  > =
  ref(
    
      UpdateProjectScheduleMutation.Variables(
        id=id,dayOfWeek=dayOfWeek,startHour=startHour,endHour=endHour,
  
      )
    
  )

public suspend fun UpdateProjectScheduleMutation.execute(

  
    
      id: java.util.UUID,dayOfWeek: Int,startHour: String,endHour: String,

  

  ): com.google.firebase.dataconnect.MutationResult<
    UpdateProjectScheduleMutation.Data,
    UpdateProjectScheduleMutation.Variables
  > =
  ref(
    
      id=id,dayOfWeek=dayOfWeek,startHour=startHour,endHour=endHour,
  
    
  ).execute()


