
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



public interface CreateStudentMutation :
    com.google.firebase.dataconnect.generated.GeneratedMutation<
      NexaConnector,
      CreateStudentMutation.Data,
      CreateStudentMutation.Variables
    >
{
  
    @kotlinx.serialization.Serializable
  public data class Variables(
  
    val studentCode: String,
    val phoneNumber: String,
    val birthDate: com.google.firebase.dataconnect.OptionalVariable<com.google.firebase.dataconnect.LocalDate?>,
    val userId: String,
    val careerId: com.google.firebase.dataconnect.OptionalVariable<@kotlinx.serialization.Serializable(with = com.google.firebase.dataconnect.serializers.UUIDSerializer::class) java.util.UUID?>
  ) {
    
    
      
      @kotlin.DslMarker public annotation class BuilderDsl

      @BuilderDsl
      public interface Builder {
        public var studentCode: String
        public var phoneNumber: String
        public var birthDate: com.google.firebase.dataconnect.LocalDate?
        public var userId: String
        public var careerId: java.util.UUID?
        
      }

      public companion object {
        @Suppress("NAME_SHADOWING")
        public fun build(
          studentCode: String,phoneNumber: String,userId: String,
          block_: Builder.() -> Unit
        ): Variables {
          var studentCode= studentCode
            var phoneNumber= phoneNumber
            var birthDate: com.google.firebase.dataconnect.OptionalVariable<com.google.firebase.dataconnect.LocalDate?> =
                com.google.firebase.dataconnect.OptionalVariable.Undefined
            var userId= userId
            var careerId: com.google.firebase.dataconnect.OptionalVariable<java.util.UUID?> =
                com.google.firebase.dataconnect.OptionalVariable.Undefined
            

          return object : Builder {
            override var studentCode: String
              get() = throw UnsupportedOperationException("getting builder values is not supported")
              set(value_) { studentCode = value_ }
              
            override var phoneNumber: String
              get() = throw UnsupportedOperationException("getting builder values is not supported")
              set(value_) { phoneNumber = value_ }
              
            override var birthDate: com.google.firebase.dataconnect.LocalDate?
              get() = throw UnsupportedOperationException("getting builder values is not supported")
              set(value_) { birthDate = com.google.firebase.dataconnect.OptionalVariable.Value(value_) }
              
            override var userId: String
              get() = throw UnsupportedOperationException("getting builder values is not supported")
              set(value_) { userId = value_ }
              
            override var careerId: java.util.UUID?
              get() = throw UnsupportedOperationException("getting builder values is not supported")
              set(value_) { careerId = com.google.firebase.dataconnect.OptionalVariable.Value(value_) }
              
            
          }.apply(block_)
          .let {
            Variables(
              studentCode=studentCode,phoneNumber=phoneNumber,birthDate=birthDate,userId=userId,careerId=careerId,
            )
          }
        }
      }
    
  }
  

  
    @kotlinx.serialization.Serializable
  public data class Data(
  
    val student_insert: StudentKey
  ) {
    
    
  }
  

  public companion object {
    public val operationName: String = "CreateStudent"

    public val dataDeserializer: kotlinx.serialization.DeserializationStrategy<Data> =
      kotlinx.serialization.serializer()

    public val variablesSerializer: kotlinx.serialization.SerializationStrategy<Variables> =
      kotlinx.serialization.serializer()
  }
}

public fun CreateStudentMutation.ref(
  
    studentCode: String,phoneNumber: String,userId: String,

  
    block_: CreateStudentMutation.Variables.Builder.() -> Unit = {}
  
): com.google.firebase.dataconnect.MutationRef<
    CreateStudentMutation.Data,
    CreateStudentMutation.Variables
  > =
  ref(
    
      CreateStudentMutation.Variables.build(
        studentCode=studentCode,phoneNumber=phoneNumber,userId=userId,
  
    block_
      )
    
  )

public suspend fun CreateStudentMutation.execute(

  
    
      studentCode: String,phoneNumber: String,userId: String,

  
    block_: CreateStudentMutation.Variables.Builder.() -> Unit = {}

  ): com.google.firebase.dataconnect.MutationResult<
    CreateStudentMutation.Data,
    CreateStudentMutation.Variables
  > =
  ref(
    
      studentCode=studentCode,phoneNumber=phoneNumber,userId=userId,
  
    block_
    
  ).execute()


