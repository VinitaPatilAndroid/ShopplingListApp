package com.example.shoppinglistapp.view.ui.productlist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglistapp.data.db.RoomAppDb
import com.example.shoppinglistapp.data.entity.response.ProductItemResponse
import com.example.shoppinglistapp.data.entity.response.ProductListResponse
import com.example.shoppinglistapp.data.repository.ProductAndCartRepository
import kotlinx.coroutines.*

class ProductItemListViewModel(app: Application) : AndroidViewModel(app){

    val productRepository = ProductAndCartRepository()
    val errorMessage = MutableLiveData<String>()
    val productList = MutableLiveData<ProductListResponse>()

    var job: Job? = null

    val loading = MutableLiveData<Boolean>()

    fun getProductList(){
        job = CoroutineScope(Dispatchers.IO).launch {
            val response = productRepository.getProductList("1","10","1")
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    productList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }

    fun insertProductInfo(entity : ProductItemResponse){
        job = CoroutineScope(Dispatchers.IO).launch{
            val productDao = RoomAppDb.getDatabase(getApplication()).productDao()
            productDao?.insertProduct(entity)
        }
    }
}