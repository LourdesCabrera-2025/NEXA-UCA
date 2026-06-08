package sv.uca.nexauca.features.login

import android.app.Activity
import android.util.Log
import androidx.lifecycle.ViewModel
import sv.uca.nexauca.data.services.auth.AuthService


class LoginViewModel :  ViewModel() {

    private val authService = AuthService()

    fun loginWithMicrosoft(activity: Activity) {
        Log.d("AUTH_MICROSOFT", "Entre a ViewModel")
        authService.loginWithMicrosoft(activity)
    }

}