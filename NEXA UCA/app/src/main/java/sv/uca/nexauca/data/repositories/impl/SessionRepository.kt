package sv.uca.nexauca.data.repositories.impl

import android.util.Log
import com.google.firebase.auth.FirebaseUser
import sv.uca.nexauca.data.firebase.FirebaseAuthProvider
import sv.uca.nexauca.presentation.core.state.ResultState
import sv.uca.nexauca.presentation.core.utils.StudentCodeGenerator

class SessionRepository {

    private val userRepository = UserRepositoryImpl()
    private val roleRepository = RoleRepositoryImpl()

    suspend fun ensureUserAndStudent(
        firebaseUser: FirebaseUser
    ): ResultState<Unit> {

        val auth = FirebaseAuthProvider.getInstance()

        Log.d("NEXA_DEBUG", "===========================")
        Log.d("NEXA_DEBUG", "FIREBASE AUTH")
        Log.d("NEXA_DEBUG", "currentUSer = ${auth.currentUser}")
        Log.d("NEXA_DEBUG", "uid = ${auth.currentUser?.uid}")
        Log.d("NEXA_DEBUG", "email = ${auth.currentUser?.email}")

        val uid = firebaseUser.uid
        val email = firebaseUser.email.orEmpty()
        val fullName = firebaseUser.displayName ?: email.substringBefore("@")
        val photoUrl = firebaseUser.photoUrl?.toString().orEmpty()
        val studentCode = StudentCodeGenerator.fromEmail(email)

        Log.d("NEXA_DEBUG", "===================")
        Log.d("NEXA_DEBUG", "INICIO DE SESION")
        Log.d("NEXA_DEBUG", "uid=$uid")
        Log.d("NEXA_DEBUG", "email=$email")
        return when (
            val existsResult = userRepository.userExists(uid)

        ) {
            is ResultState.Success -> {

                Log.d("NEXA_DEBUG", "userExists = $existsResult")
                if (existsResult.data) {

                    ResultState.Success(Unit)
                } else {

                    Log.d("NEXA_DEBUG", "ENTRANDO A CREAR USUARIO")

                    try {
                        Log.d("NEXA_DEBUG", "ANTES getStudentRoleId")

                        val roleId = roleRepository.getStudentRoleId()

                        Log.d("NEXA_DEBUG", "roleId = $roleId")

                        val createUserResult = userRepository.createUser(
                            id = uid,
                            email = email,
                            fullName = fullName,
                            photoUrl = photoUrl,
                            roleId = roleId
                        )

                        Log.d("NEXA_DEBUG", "createUserResult = $createUserResult")

                        if (createUserResult is ResultState.Error) {
                            return createUserResult
                        }

                        val studentResult = userRepository.createStudent(
                            studentCode = studentCode,
                            phoneNumber = "",
                            birthDate = null,
                            userId = uid,
                            careerId = null
                        )

                        Log.d("NEXA_DEBUG", "studentResult = $studentResult")
                        studentResult
                    } catch (e: Exception) {
                        Log.e("NEXA_DEBUG", "EXCEPTION COMPLETA", e)

                        ResultState.Error(
                            message = e.message ?: "Error desconocido",
                            exception = e
                        )
                    }
                }
            }
                is ResultState.Error -> {
                    Log.e("NEXA_DEBUG", "ERROR EN userExists: ${existsResult.message}",
                        existsResult.exception
                    )
                existsResult
                }
                else -> {
                ResultState.Error("No se pudo verificar la sesión")
                }
        }
    }
}
