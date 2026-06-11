package sv.uca.nexauca.data.repositories.impl

import android.util.Log
import com.google.firebase.dataconnect.LocalDate
import sv.uca.nexauca.data.firebase.FirebaseAuthProvider
import sv.uca.nexauca.data.repositories.api.UserApiRepository
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.presentation.core.state.ResultState
import java.util.UUID

class UserRepositoryImpl : UserApiRepository{


    private val connector = FirebaseAuthProvider.getDataConnect()

    private fun String.toDataConnectLocalDate(): LocalDate {
        val parts = this.split("-")

        return LocalDate(
            year = parts[0].toInt(),
            month = parts[1].toInt(),
            day = parts[2].toInt()
        )
    }

    override suspend fun userExists(id: String): ResultState<Boolean> {
        return  try {
            val result = connector.getUserById.execute(id = id)
            ResultState.Success(result.data.users.isNotEmpty())
        }catch (e: Exception) {
            ResultState.Error(
                message = e.message ?: "Error al verificar usuario",
                exception = e
            )
        }
    }

    override suspend fun createUser(
        id: String,
        email: String,
        fullName: String,
        photoUrl: String,
        roleId: UUID
    ): ResultState<Unit> {
        return try {
            Log.d("NECA_DEBUG", "================ create user ==================")
            Log.d("NECA_DEBUG", "ID = $id")
            Log.d("NEXA_DEBUG", "email = $email")
            Log.d("NEXA_DEBUG", "roleId =$roleId")

            val result = connector.createUser.execute(
                id = id,
                email = email,
                fullName = fullName,
                photoUrl = photoUrl,
                roleId = roleId
            )

            Log.d("NEXA_DEBUG", "createUser OK")
            Log.d("NEXA_DEBUG", result.data.toString())

            ResultState.Success(Unit)
        }catch (e: Exception) {
            Log.e("NEXA_DEBUG", "ERROR CREATE USER",e)

            ResultState.Error(
                e.message ?: "Error al crear usuario", e
            )
        }
    }
    override suspend fun createStudent(
        studentCode: String,
        phoneNumber: String?,
        birthDate: String?,
        userId: String,
        careerId: UUID?
    ): ResultState<Unit> {
        return  try {
            Log.d("NEXA_DEBUG", "=========== CREATE STUDENT =========")
            Log.d("NEXA_DEBUG", "studentCode = $studentCode")
            Log.d("NEXA_DEBUG", "userId= ${userId}")

            val result = connector.createStudent.execute(
                studentCode = studentCode,
                phoneNumber = phoneNumber?:"",
                userId = userId
            ){
                this.birthDate = birthDate?.toDataConnectLocalDate()
                this.careerId = careerId
            }

            Log.d("NEXA_DEBUG", "createStudent OK")
            Log.d("NEXA_DEBUG", result.data.toString())

            ResultState.Success(Unit)
        } catch (e: Exception) {
            Log.e("NEXA_DEBUG", "ERROR CREATE STUDENT", e)

            ResultState.Error(
                e.message ?: "Error al crear estudiante", e
            )
        }
    }
}