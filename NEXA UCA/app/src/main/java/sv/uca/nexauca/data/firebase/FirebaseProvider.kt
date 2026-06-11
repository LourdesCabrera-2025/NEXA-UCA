package sv.uca.nexauca.data.firebase


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.dataconnect.FirebaseDataConnect
import sv.uca.nexauca.dataconnect.NexaConnector
import sv.uca.nexauca.dataconnect.instance


class FirebaseAuthProvider private constructor() {

    val dataConnect = NexaConnector.instance

    init {
       // dataConnect.dataConnect.useEmulator("192.168.1.3" , 9399)
    }
    companion object {

        private val provider : FirebaseAuthProvider by lazy {
            FirebaseAuthProvider()
        }

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
        fun getDataConnect() : NexaConnector {
            return provider.dataConnect
        }
    }


}
