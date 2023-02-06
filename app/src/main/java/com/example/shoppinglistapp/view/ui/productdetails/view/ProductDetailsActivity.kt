package com.example.shoppinglistapp.view.ui.productdetails.view

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.data.entity.response.ProductImage
import com.example.shoppinglistapp.data.entity.response.SingleDataItem
import com.example.shoppinglistapp.databinding.ActivityProductDetailsBinding
import com.example.shoppinglistapp.view.ui.productdetails.adapter.ProductDetailsAdapter
import com.example.shoppinglistapp.view.ui.productdetails.viewmodel.ProductDetailsViewModel

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductDetailsBinding
    private lateinit var viewModel:ProductDetailsViewModel
    private var productDetailsAdapter:ProductDetailsAdapter? = null
    var context: Context? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init(){
        binding.toolbarProductDetails.tvToolbarTitle.setText("Product Details")
        binding.toolbarProductDetails.ivForwardArrow.setOnClickListener {
            finish()
        }
        binding.toolbarProductDetails.ivCart.visibility = View.INVISIBLE
        viewModel = ViewModelProvider(this).get(ProductDetailsViewModel::class.java)
        apiCall()
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL ,false)

    }

    private fun apiCall() {
        viewModel.getProductDetails(intent.extras?.getInt("id_value").toString())
        setObserver()
    }

    private fun setObserver() {
        viewModel.productDetailList.observe(this, Observer {
           setData(it)
            setAdapter(it.data.productImages)
        })
    }

    fun setAdapter(productImageList: List<ProductImage>) {
        productDetailsAdapter = ProductDetailsAdapter(productImageList, context)
       binding.recyclerView.adapter = productDetailsAdapter
    }

    fun setData(it: SingleDataItem) {
        binding.tvTitle.setText(it.data.name)
        binding.tvSubtitle.setText(it.data.producer)
        binding.ratBar.rating = it.data.rating.toFloat()
        binding.tvDescription.setText(it.data.description)
        binding.tvPrice.text = it.data.cost.toString()
        binding.tvSmallTitle.text = it.data.productCategoryId.toString()
    }
}