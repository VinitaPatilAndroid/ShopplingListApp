package com.example.shoppinglistapp.data.networkservices

import com.example.shoppinglistapp.data.model.ProductListResponse
import com.example.shoppinglistapp.data.model.SingleProductItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiServices {

    @GET(value = "api/products/getList")
    suspend fun ProductItemList(
        @Query(value = "product_category_id") product_category_id: String,
        @Query(value = "limit ") limit: String,
        @Query(value = "page ") page: String
    ): Response<ProductListResponse>

    @GET(value = "api/products/getDetail")
    suspend fun ProductDetail(
        @Query(value = "product_id") product_id: String
    ): Response<SingleProductItem>

    companion object {
        var apiService: ApiServices? = null
        fun getInstance(): ApiServices {
            if (apiService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("http://staging.php-dev.in:8844/trainingapp/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                apiService = retrofit.create(ApiServices::class.java)
            }
            return apiService!!
        }

    }
}