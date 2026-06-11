package sv.uca.nexauca.data.repositories.impl

import android.util.Log
import sv.uca.nexauca.data.firebase.FirebaseAuthProvider
import sv.uca.nexauca.data.repositories.api.RoleApiRepository
import sv.uca.nexauca.dataconnect.execute
import java.util.UUID

class RoleRepositoryImpl : RoleApiRepository {

    private val connector = FirebaseAuthProvider.getDataConnect()

    override suspend fun getStudentRoleId(): UUID {
        val result = connector.getRoles.execute()

        Log.d("NEXA_DEBUG", "TOTAL ROLES = ${result.data.roles.size}")

        result.data.roles.forEach {
            Log.d("NEXA_DEBUG", "ROL -> id=${it.id} nombre='${it.name}'")
        }

        val studentRole = result.data.roles.firstOrNull() {
            it.name.equals("Estudiante", ignoreCase = true)
        }

       if (studentRole == null) {
           throw Exception("No existe el rol estudiante")
       }

        return  studentRole.id
    }
}
