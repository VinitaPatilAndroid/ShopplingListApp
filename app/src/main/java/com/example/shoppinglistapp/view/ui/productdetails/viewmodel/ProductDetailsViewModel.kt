package com.example.shoppinglistapp.view.ui.productdetails.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglistapp.data.entity.response.ProductListResponse
import com.example.shoppinglistapp.data.entity.response.SingleDataItem
import com.example.shoppinglistapp.data.repository.ProductAndCartRepository
import kotlinx.coroutines.*

class ProductDetailsViewModel :ViewModel() {

    val productDetailsRepository = ProductAndCartRepository()
    val errorMessage = MutableLiveData<String>()
    var job: Job? = null
    val loading = MutableLiveData<Boolean>()
    val productDetailList = MutableLiveData<SingleDataItem>()

    fun getProductDetails(product_id:String){
        job = CoroutineScope(Dispatchers.IO).launch {
           val response = productDetailsRepository.getProductDetail(product_id)
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    productDetailList.postValue(response.body())
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


}