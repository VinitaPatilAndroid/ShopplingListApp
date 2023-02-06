package com.example.shoppinglistapp.view.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapp.databinding.ActivitySplashBinding
import com.example.shoppinglistapp.view.ui.productlist.ProductListActivity
import com.example.shoppinglistapp.view.ui.splash.splash.viewmodel.SplashState
import com.example.shoppinglistapp.view.ui.splash.splash.viewmodel.SplashViewModel

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val splashViewModel = ViewModelProvider(this).get(SplashViewModel::class.java)
        splashViewModel.liveData.observe(this, Observer {
            when (it) {
                is SplashState.MainActivity -> {
                    goToMainActivity()
                }
                else -> {}
            }
        })
    }

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, ProductListActivity::class.java))
    }
}