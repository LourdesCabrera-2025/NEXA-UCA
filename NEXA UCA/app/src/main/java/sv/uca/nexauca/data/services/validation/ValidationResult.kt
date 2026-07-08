package sv.uca.nexauca.data.services.validation

import sv.uca.nexauca.data.models.Participant

sealed class ValidationResult {

    data class Success(
        val participant: Participant
    ) : ValidationResult()

    object ParticipantNotFound : ValidationResult()

    object ProjectInactive : ValidationResult()

    object InvalidDay : ValidationResult()

    object InvalidHour : ValidationResult()

    object OutOfRange : ValidationResult()
}