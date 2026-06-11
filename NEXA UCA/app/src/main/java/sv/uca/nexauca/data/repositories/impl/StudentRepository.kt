package sv.uca.nexauca.data.repositories.impl

import sv.uca.nexauca.data.firebase.FirebaseAuthProvider
import sv.uca.nexauca.data.mappers.toModel
import sv.uca.nexauca.data.models.Student
import sv.uca.nexauca.data.repositories.api.StudentApiRepository
import sv.uca.nexauca.dataconnect.execute
import sv.uca.nexauca.presentation.core.state.ResultState

class StudentRepositoryImpl : StudentApiRepository {

    private val connector = FirebaseAuthProvider.getDataConnect()

    override suspend fun getMyStudent(): ResultState<Student> {
        return try {
            val result = connector.getMyStudent.execute()
            val student = result.data.students.firstOrNull()?.toModel()

            if (student != null) {
                ResultState.Success(student)
            } else {
                ResultState.Error("No se encontro información del estudiante")
            }
        }catch (e: Exception) {
            ResultState.Error(
                message = e.message ?: "Error al obtener estudiante",
                exception = e
            )
        }
    }
}