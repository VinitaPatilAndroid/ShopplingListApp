package com.example.shoppinglistapp.data.entity.response

import com.google.gson.annotations.SerializedName

data class ProductItemResponse(
    @field:SerializedName("product_images")
    val productImages: String? = null,

    @field:SerializedName("cost")
    val cost: Int? = null,

    @field:SerializedName("created")
    val created: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("rating")
    val rating: Int? = null,

    @field:SerializedName("producer")
    val producer: String? = null,

    @field:SerializedName("description")
    val description: String? = null,

    @field:SerializedName("modified")
    val modified: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("view_count")
    val viewCount: Int? = null,

    @field:SerializedName("product_category_id")
    val productCategoryId: Int? = null
)
