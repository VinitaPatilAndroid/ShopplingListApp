package com.example.shoppinglistapp.data.model


import com.google.gson.annotations.SerializedName

data class ProductImage(
    @SerializedName("created")
    val created: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("image")
    val image: String = "",
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("product_id")
    val productId: Int = 0
)