package com.example.shoppinglistapp.view.ui.cartDetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapp.data.db.RoomAppDb
import com.example.shoppinglistapp.data.model.ProductItemResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class CartViewModel (app: Application) : AndroidViewModel(app) {

    var allProduct : MutableLiveData<List<ProductItemResponse>> =  MutableLiveData()

    init{
        getAllProduct()
    }

    fun getAllProductObservers(): MutableLiveData<List<ProductItemResponse>> {
        return allProduct
    }

    fun getAllProduct(){
      viewModelScope.launch(Dispatchers.IO) {
           val productDao = RoomAppDb.getDatabase((getApplication()))?.productDao()
           val list = productDao?.getAllProductInfo()
           allProduct.postValue(list)
       }
    }

    fun deleteProductInfo(entity : ProductItemResponse){
     viewModelScope.launch(Dispatchers.IO) {
            val productDao = RoomAppDb.getDatabase((getApplication()))?.productDao()
            productDao?.deleteProduct(entity)
            getAllProduct()
        }
    }
}