package sv.uca.nexauca.presentation.core.events

import sv.uca.nexauca.presentation.core.notifier.ToastSonner

/**
 * Representa los eventos de la interfaz de usuario (UI) que deben ser procesados por la vista.
 *
 * Esta [sealed class] define una jerarquía cerrada de eventos de notificación, diseñados
 * principalmente para ser consumidos por componentes de alertas como `Compose Sonner` o `Snackbars`
 *
 * El uso de una clase sellada permite que la UI maneje de forma exhaustiva todos los posibles
 * estados de retroalimentación mediante una expresión `when`
 */

sealed class UIEvent {

    data class ShowToast(
        val toastSonner: ToastSonner
    ) : UIEvent ()

    data object NavigateToHome : UIEvent()
    data object NavigateToLogin : UIEvent()

}