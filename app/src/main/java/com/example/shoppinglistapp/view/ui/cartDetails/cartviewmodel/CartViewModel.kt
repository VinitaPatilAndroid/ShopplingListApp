package com.example.shoppinglistapp.view.ui.cartDetails.cartviewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglistapp.data.db.RoomAppDb
import com.example.shoppinglistapp.data.entity.response.ProductItemResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CartViewModel (app: Application) : AndroidViewModel(app) {

    var allProduct : MutableLiveData<List<ProductItemResponse>> =  MutableLiveData()
    var job: Job? = null

    init{
        getAllProduct()
    }

    fun getAllProductObservers(): MutableLiveData<List<ProductItemResponse>> {
        return allProduct
    }

    fun getAllProduct(){
       job = CoroutineScope(Dispatchers.IO).launch {
           val productDao = RoomAppDb.getDatabase((getApplication()))?.productDao()
           val list = productDao?.getAllProductInfo()
           allProduct.postValue(list)
       }
    }

    fun deleteProductInfo(entity : ProductItemResponse){
        job = CoroutineScope(Dispatchers.IO).launch {
            val productDao = RoomAppDb.getDatabase((getApplication()))?.productDao()
            productDao?.deleteUser(entity)
            getAllProduct()
        }
    }
}