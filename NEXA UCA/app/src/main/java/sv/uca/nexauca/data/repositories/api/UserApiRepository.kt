package sv.uca.nexauca.data.repositories.api

import sv.uca.nexauca.dataconnect.GetMyStudentQuery
import sv.uca.nexauca.presentation.core.state.ResultState
import java.util.UUID

interface UserApiRepository {
    suspend fun userExists(id: String): ResultState<Boolean>

    suspend fun createUser(
        id: String,
        email: String,
        fullName: String,
        photoUrl: String,
        roleId: UUID
    ) : ResultState<Unit>

    suspend fun createStudent(
        studentCode: String,
        phoneNumber: String?,
        birthDate: String?,
        userId:String,
        careerId: UUID?
    ) : ResultState<Unit>

    suspend fun getDataStudent() : ResultState<GetMyStudentQuery.Data.StudentsItem>
}