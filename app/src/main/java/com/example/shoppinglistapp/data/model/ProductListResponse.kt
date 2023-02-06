package com.example.shoppinglistapp.data.model

import com.example.shoppinglistapp.data.model.ProductItemResponse
import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @field:SerializedName("data")
    val productItemResponse: List<ProductItemResponse>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)
