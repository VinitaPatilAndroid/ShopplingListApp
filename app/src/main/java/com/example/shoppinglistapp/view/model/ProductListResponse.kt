package com.example.shoppinglistapp.view.model

import com.google.gson.annotations.SerializedName

data class ProductListResponse(
    @field:SerializedName("data")
    val data1: List<ProductItem>? = null,

    @field:SerializedName("status")
    val status: Int? = null
)
