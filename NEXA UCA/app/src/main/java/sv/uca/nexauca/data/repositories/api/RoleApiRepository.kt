package sv.uca.nexauca.data.repositories.api

import java.util.UUID


interface RoleApiRepository {
    suspend fun getStudentRoleId() : UUID
}