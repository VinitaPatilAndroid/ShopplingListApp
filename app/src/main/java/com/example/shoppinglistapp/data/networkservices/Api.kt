package com.example.shoppinglistapp.data.networkservices

import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkApi {

    @GET(value = "api/products/getList")
    fun ProductItemList(
        @Query(value = "product_category_id")product_category_id:String,
        @Query(value = "limit ")limit:String,
        @Query(value = "page ")page:String
    )
}