package com.example.shoppinglistapp.view.ui.splashscreen.splash.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    val liveData : LiveData<SplashState>
        get() = mutableData

    private val mutableData = MutableLiveData<SplashState>()

    init {
        GlobalScope.launch {
            delay(3000)
            mutableData.postValue(SplashState.MainActivity())
        }
    }
}

sealed class SplashState {
    class MainActivity : SplashState()
}