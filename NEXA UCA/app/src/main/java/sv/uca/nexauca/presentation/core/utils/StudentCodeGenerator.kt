package sv.uca.nexauca.presentation.core.utils

object StudentCodeGenerator {
    fun fromEmail(email: String) : String {
        return email.substringBefore("@")
            .filter {it.isLetterOrDigit()}
            .uppercase()
    }
}