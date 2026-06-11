package sv.uca.nexauca.data.repositories.api


import sv.uca.nexauca.data.models.Student
import sv.uca.nexauca.presentation.core.state.ResultState


interface StudentApiRepository {
    suspend fun getMyStudent() : ResultState<Student>
}