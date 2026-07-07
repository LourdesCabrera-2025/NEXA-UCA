package sv.uca.nexauca.presentation.screens.settings

import kotlinx.serialization.Serializable
import sv.uca.nexauca.dataconnect.GetMyStudentQuery
import sv.uca.nexauca.data.repositories.impl.UserRepositoryImpl

@Serializable
data class SettingsUIState (
    val isLoading: Boolean = false,
    val student: GetMyStudentQuery.Data.StudentsItem ? = null,
    val isNotificationsEnabled: Boolean = true,
    val isLocationEnabled: Boolean = false,
    val isDarkMode:  Boolean = false
)