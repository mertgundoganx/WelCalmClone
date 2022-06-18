package com.mertgundogan.welcalmclone.ui.login

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    val isUserLogin: MutableLiveData<Boolean> = MutableLiveData(false)

    fun loginFirebaseAuth(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                auth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener() { task ->
                        if (task.isSuccessful) {
                            Log.d("TAG", "signInWithEmail:success")
                            isUserLogin.postValue(true)
                        } else {
                            Log.w("TAG", "signInWithEmail:failure", task.exception)
                            isUserLogin.postValue(false)
                        }
                    }
            } catch (e: Exception) {
                Log.e("EXC", e.toString())
            }
        }
    }

}