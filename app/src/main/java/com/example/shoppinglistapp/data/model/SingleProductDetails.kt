package com.example.shoppinglistapp.data.model

import com.example.shoppinglistapp.data.model.ProductImage
import com.google.gson.annotations.SerializedName

data class SingleProductDetails(
    @SerializedName("cost")
    val cost: Int = 0,
    @SerializedName("created")
    val created: String = "",
    @SerializedName("description")
    val description: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("modified")
    val modified: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("producer")
    val producer: String = "",
    @SerializedName("product_category_id")
    val productCategoryId: Int = 0,
    @SerializedName("product_images")
    val productImages: List<ProductImage> = listOf(),
    @SerializedName("rating")
    val rating: Int = 0,
    @SerializedName("view_count")
    val viewCount: Int = 0
)