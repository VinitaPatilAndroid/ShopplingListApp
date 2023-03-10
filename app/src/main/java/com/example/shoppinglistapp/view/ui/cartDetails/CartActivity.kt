package com.example.shoppinglistapp.view.ui.cartDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglistapp.data.model.ProductItemResponse
import com.example.shoppinglistapp.databinding.ActivityCartBinding
import com.example.shoppinglistapp.view.ui.productlist.ProductAdapter

class CartActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCartBinding
    private lateinit var viewModel: CartViewModel
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    fun init(){
        binding.toolbarCart.tvToolbarTitle.setText("My Cart")
        binding.toolbarCart.ivCart.visibility = View.INVISIBLE
        binding.toolbarCart.ivForwardArrow.setOnClickListener {
            finish()
        }
        viewModel = ViewModelProvider(this).get(CartViewModel::class.java)

        viewModel.getAllProductObservers().observe(this, Observer {
            setUpProductItemListAdapter(it as ArrayList<ProductItemResponse>)
        })
    }
    private fun setUpProductItemListAdapter(
        productItemList: ArrayList<ProductItemResponse>,
    ) {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        productAdapter = ProductAdapter(productItemList,this,{
                   viewModel.deleteProductInfo(it)
        },true)
        binding.rvCartList.layoutManager = layoutManager
        binding.rvCartList.adapter = productAdapter
    }
}