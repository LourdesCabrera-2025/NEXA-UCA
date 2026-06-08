package sv.uca.nexauca.data.firebase


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.dataconnect.FirebaseDataConnect
import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.instance

class FirebaseAuthProvider private constructor() {

    val dataConnect = NexaConnector.instance.dataConnect

    init {
        dataConnect.useEmulator("127.0.0.1", 9399)
    }

    companion object {

        @Volatile
        private var authProvider: FirebaseAuth? = null

        fun getInstance(): FirebaseAuth {
            if (authProvider == null) {
                synchronized(this) {
                    if (authProvider == null) {
                        authProvider = FirebaseAuth.getInstance()
                    }
                }
            }
            return authProvider !!
        }
    }


}
