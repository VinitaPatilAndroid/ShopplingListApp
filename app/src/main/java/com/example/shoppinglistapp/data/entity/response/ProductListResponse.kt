package com.example.shoppinglistapp.data.entity.response

import com.example.shoppinglistapp.data.entity.response.ProductItemResponse
import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @field:SerializedName("data")
    val data1: List<ProductItemResponse>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)
