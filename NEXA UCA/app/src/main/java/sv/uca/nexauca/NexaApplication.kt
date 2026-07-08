package sv.uca.nexauca

import android.app.Application
import sv.uca.nexauca.data.firebase.FirebaseModule

class NexaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        FirebaseModule.init(this)
    }
}