package sv.uca.nexauca.presentation.core.notifier


import com.dokar.sonner.ToastType
import com.dokar.sonner.ToasterState

enum class NexaToastType{
    SUCCESS,
    ERROR,
    WARNING,
    INFO
}


data class ToastSonner (
    val title: String,
    val message: String,
    val type: NexaToastType
)

fun showNexaToast(
    toast: ToastSonner,
    toasterState: ToasterState,

) {
    val nexaSonnerType = when (toast.type) {
        NexaToastType.SUCCESS -> ToastType.Success
        NexaToastType.ERROR -> ToastType.Error
        NexaToastType.WARNING -> ToastType.Warning
        NexaToastType.INFO -> ToastType.Info
    }

    toasterState.show(
        message = toast.message,
        type = nexaSonnerType
    )
}