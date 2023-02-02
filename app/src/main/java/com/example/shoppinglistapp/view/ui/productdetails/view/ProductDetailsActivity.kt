package com.example.shoppinglistapp.view.ui.productdetails.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.shoppinglistapp.databinding.ActivityProductDetailsBinding

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProductDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.toolbar.tvToolbarTitle.setText("Product Details")
        binding.toolbar.ivForwardArrow.setOnClickListener {
            finish()
        }
    }
}