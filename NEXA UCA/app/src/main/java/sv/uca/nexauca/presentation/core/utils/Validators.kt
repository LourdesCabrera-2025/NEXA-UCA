package sv.uca.nexauca.presentation.core.utils



fun getInitials(fullName: String) : String {

    val words = fullName.trim()
        .split("\\s+".toRegex())
        .filter { it.isNotBlank() }

    return when {
        words.isEmpty() -> ""
        words.size == 1 -> words[0].take(1).uppercase()
        else -> (words.first().take(1) + words.last().take(1)).uppercase()
    }
}