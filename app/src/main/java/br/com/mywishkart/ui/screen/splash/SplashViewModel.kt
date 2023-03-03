package br.com.mywishkart.ui.screen.splash

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import br.com.mywishkart.firebase.RemoteConfigManager
import com.google.firebase.FirebaseApp

class SplashViewModel() : ViewModel() {

    var isSuccess: Boolean? by mutableStateOf(null)
        private set

    fun initConfig(context: Context) {
        startRemoteConfig(context)
    }

    private fun startRemoteConfig(context: Context) {
        FirebaseApp.initializeApp(context)
        RemoteConfigManager.fetch {isSuccess ->
            if (isSuccess) remoteConfigSuccess()else remoteConfigError()
        }
    }

    private fun remoteConfigError() {
        isSuccess = false
        Log.e("FirebaseConfiguration", "Failed!")
    }

    private fun remoteConfigSuccess() {
        isSuccess = true
        Log.d("FirebaseConfiguration", "Success!")
    }

}