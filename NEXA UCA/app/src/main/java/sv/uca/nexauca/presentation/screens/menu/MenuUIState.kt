package sv.uca.nexauca.presentation.screens.menu

import kotlinx.serialization.Serializable
import sv.uca.nexauca.dataconnect.GetMyStudentQuery

@Serializable
data class MenuUIState (
    val isLoading: Boolean = false,
    val student: GetMyStudentQuery.Data.StudentsItem ? = null
)