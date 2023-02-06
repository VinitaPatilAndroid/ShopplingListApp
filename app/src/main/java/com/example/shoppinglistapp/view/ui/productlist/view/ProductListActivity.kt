package com.example.shoppinglistapp.view.ui.productlist.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.data.entity.response.ProductItemResponse
import com.example.shoppinglistapp.databinding.ActivityMainBinding
import com.example.shoppinglistapp.view.ui.cartDetails.view.CartActivity
import com.example.shoppinglistapp.view.ui.productlist.adapter.ProductAdapter
import com.example.shoppinglistapp.view.ui.productlist.viewmodel.ProductItemListViewModel

class ProductListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: ProductItemListViewModel
    var productItemList = ArrayList<ProductItemResponse>()
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){
        viewModel = ViewModelProvider(this).get(ProductItemListViewModel::class.java)

        apiCall()
        binding.toolbar.tvToolbarTitle.setText("Product List")
        binding.toolbar.ivForwardArrow.visibility = View.GONE
        binding.toolbar.ivCart.setOnClickListener {
            startActivity(Intent(this, CartActivity::class.java))
        }

    }

    private fun apiCall() {
         viewModel.getProductList()
         setObserver()
    }

    private fun setObserver() {
        viewModel.productList.observe(this, Observer {
         productItemList = it.data1 as ArrayList<ProductItemResponse>
            setUpProductItemListAdapter(productItemList)
        })
    }

    private fun setUpProductItemListAdapter(
        productItemList: ArrayList<ProductItemResponse>,
    ) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        productAdapter = ProductAdapter(productItemList,this,{
            viewModel.insertProductInfo(it)
        })
        binding.rvProductList.layoutManager = layoutManager
        binding.rvProductList.adapter = productAdapter
    }

}