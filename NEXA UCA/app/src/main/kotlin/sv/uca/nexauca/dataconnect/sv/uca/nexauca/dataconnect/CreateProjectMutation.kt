
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



public interface CreateProjectMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateProjectMutation.Data,
      CreateProjectMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val name: String,
    val description: String,
    val projectTypeId: @kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID,
    val supervisorId: String,
    val startDate: com.google.firebase.dataconnect.LocalDate,
    val endDate: com.google.firebase.dataconnect.LocalDate,
    val latitude: Double,
    val longitude: Double,
    val allowedRadius: Double,
    val maxStudents: Int,
    val totalRequiredHours: Int
  ) {
    
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val project_insert: ProjectKey
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateProject"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateProjectMutation.ref(
  
    name: String,description: String,projectTypeId: java.util.UUID,supervisorId: String,startDate: com.google.firebase.dataconnect.LocalDate,endDate: com.google.firebase.dataconnect.LocalDate,latitude: Double,longitude: Double,allowedRadius: Double,maxStudents: Int,totalRequiredHours: Int,

  
  
): com.google.firebase.dataconnect.MutationRef<
    CreateProjectMutation.Data,
    CreateProjectMutation.Variables
  > =
  ref(
    
      CreateProjectMutation.Variables(
        name=name,description=description,projectTypeId=projectTypeId,supervisorId=supervisorId,startDate=startDate,endDate=endDate,latitude=latitude,longitude=longitude,allowedRadius=allowedRadius,maxStudents=maxStudents,totalRequiredHours=totalRequiredHours,
  
      )
    
  )

public suspend fun CreateProjectMutation.execute(

  
    
      name: String,description: String,projectTypeId: java.util.UUID,supervisorId: String,startDate: com.google.firebase.dataconnect.LocalDate,endDate: com.google.firebase.dataconnect.LocalDate,latitude: Double,longitude: Double,allowedRadius: Double,maxStudents: Int,totalRequiredHours: Int,

  

  ): com.google.firebase.dataconnect.MutationResult<
    CreateProjectMutation.Data,
    CreateProjectMutation.Variables
  > =
  ref(
    
      name=name,description=description,projectTypeId=projectTypeId,supervisorId=supervisorId,startDate=startDate,endDate=endDate,latitude=latitude,longitude=longitude,allowedRadius=allowedRadius,maxStudents=maxStudents,totalRequiredHours=totalRequiredHours,
  
    
  ).execute()


