package com.example.shoppinglistapp.view.ui.productdetails

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shoppinglistapp.data.model.SingleProductItem
import com.example.shoppinglistapp.data.repository.ProductAndCartRepository
import kotlinx.coroutines.*

class ProductDetailsViewModel : ViewModel() {

    val productDetailsRepository = ProductAndCartRepository()
    val errorMessage = MutableLiveData<String>()
    val loading = MutableLiveData<Boolean>()
    val productDetailList = MutableLiveData<SingleProductItem>()

    fun getProductDetails(product_id:String){
        viewModelScope.launch(Dispatchers.IO) {
           val response = productDetailsRepository.getProductDetail(product_id)
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        productDetailList.postValue(response.body())
                        loading.value = false
                    }
                } else {
                    onError("Error : ${response.message()} ")
                }
        }
    }

    private fun onError(message: String) {
        errorMessage.value = message
        loading.value = false
    }

    override fun onCleared() {
        super.onCleared()

    }

}

