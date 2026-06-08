package sv.uca.nexauca.data.services.auth

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import sv.uca.nexauca.data.firebase.FirebaseAuthProvider


class AuthService  {

    private val firebaseAuth: FirebaseAuth = FirebaseAuthProvider.getInstance()

    private fun microsoftProvider(): OAuthProvider {
        val  provider = OAuthProvider.newBuilder("microsoft.com")

        provider.addCustomParameter("prompt", "consent")

        return provider.build()
    }

    fun loginWithMicrosoft(activity: Activity) {
        Log.d("AUTH_MICROSOFT","Entre a AuthService")
        val provider = microsoftProvider()

        firebaseAuth.startActivityForSignInWithProvider(
            activity,
            provider
        )

            .addOnSuccessListener { result ->

                val user = result.user

                Log.d("AUTH_MICROSOFT", "Login exitoso")
            }

            .addOnFailureListener { exception ->
                Log.e("AUTH_MICROSOFT", "Error en Microsoft OAUTH", exception)
            }
    }


}