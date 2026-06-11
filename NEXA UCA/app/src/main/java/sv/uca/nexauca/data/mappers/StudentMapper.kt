package sv.uca.nexauca.data.mappers

import sv.uca.nexauca.data.models.Career
import sv.uca.nexauca.data.models.Department
import sv.uca.nexauca.data.models.Role
import sv.uca.nexauca.data.models.Student
import sv.uca.nexauca.dataconnect.GetMyStudentQuery


fun GetMyStudentQuery.Data.StudentsItem.toModel(): Student {

    return Student(
        id = id.toString(),
        studentCode = studentCode,
        phoneNumber = phoneNumber,
        birthDate = null,
        userId = user.id,
        email = user.email,
        fullName = user.fullName,
        photoUrl = user.photoUrl,
        isActive = user.isActive,

        role = Role (
            id = user.role.id.toString(),
            name = user.role.name
        ),

        career = career?.let {
            Career (
                id = it.id.toString(),
                name = it.name,
                department = Department(
                    id = it.department.id.toString(),
                    name = it.department.name
                )
            )
        }
    )
}