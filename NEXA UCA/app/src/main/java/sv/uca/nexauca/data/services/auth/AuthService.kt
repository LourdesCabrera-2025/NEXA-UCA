package sv.uca.nexauca.data.services.auth

import android.app.Activity
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.OAuthProvider
import kotlinx.coroutines.tasks.await
import sv.uca.nexauca.data.firebase.FirebaseAuthProvider


class AuthService  {

    private val firebaseAuth: FirebaseAuth = FirebaseAuthProvider.getInstance()

    private fun microsoftProvider(): OAuthProvider {
        return OAuthProvider.newBuilder("microsoft.com")
            .addCustomParameter("tenant", "6d77cef0-e8f4-4ed0-b160-3b15a8315327")
            .addCustomParameter("prompt", "select_account")
            .setScopes(
                listOf(
                    "openid",
                    "profile",
                    "email"
                )
            )
            .build()
    }

    suspend fun loginWithMicrosoft(activity: Activity) : FirebaseUser {

        val pendingResult = firebaseAuth.pendingAuthResult

        val result = if (pendingResult != null) {
            pendingResult.await()
        } else {
            firebaseAuth
                .startActivityForSignInWithProvider(
                    activity,
                    microsoftProvider()
                )
                .await()
        }


        return result.user ?: throw Exception("No se puede obtener el usuario autenticado")
    }

    suspend fun getPendingMicrosoftUser(): FirebaseUser ? {
        val pendingResult = firebaseAuth.pendingAuthResult ?:return null
        val result = pendingResult.await()
        return  result.user
    }

    fun currentUser() : FirebaseUser ? {
        return  firebaseAuth.currentUser
    }

    fun logout() {
        firebaseAuth.signOut()
    }

}