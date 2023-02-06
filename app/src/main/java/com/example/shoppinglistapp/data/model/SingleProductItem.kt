package com.example.shoppinglistapp.data.model


import com.example.shoppinglistapp.data.model.SingleProductDetails
import com.google.gson.annotations.SerializedName

data class SingleProductItem(
    @SerializedName("data")
    val singleProduct: SingleProductDetails = SingleProductDetails(),
    @SerializedName("status")
    val status: Int = 0
)