package com.mertgundogan.welcalmclone.ui.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val auth: FirebaseAuth
) : ViewModel() {

    private val currentUser: FirebaseUser? = auth.currentUser
    val isUserLogin: MutableLiveData<Boolean> = MutableLiveData(null)

    init {
        firebaseAuthControl()
    }

    private fun firebaseAuthControl() {
        if (currentUser != null) {
            isUserLogin.postValue(true)
        } else {
            isUserLogin.postValue(false)
        }
    }

}