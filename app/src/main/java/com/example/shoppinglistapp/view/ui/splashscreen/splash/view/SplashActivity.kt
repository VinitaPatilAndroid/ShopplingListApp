package com.example.shoppinglistapp.view.ui.splashscreen.splash.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglistapp.R
import com.example.shoppinglistapp.databinding.ActivityCartBinding
import com.example.shoppinglistapp.databinding.ActivitySplashBinding
import com.example.shoppinglistapp.view.ui.productlist.view.ProductListActivity
import com.example.shoppinglistapp.view.ui.splashscreen.splash.viewmodel.SplashState
import com.example.shoppinglistapp.view.ui.splashscreen.splash.viewmodel.SplashViewModel

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
            }
        })
    }

    private fun goToMainActivity() {
        finish()
        startActivity(Intent(this, ProductListActivity::class.java))
    }
}