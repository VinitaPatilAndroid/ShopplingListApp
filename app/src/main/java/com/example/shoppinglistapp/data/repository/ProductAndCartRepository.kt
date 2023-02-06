package com.example.shoppinglistapp.data.repository

import com.example.shoppinglistapp.data.networkservices.ApiServices

class ProductAndCartRepository {

    suspend fun getProductList(product_category_id: String,limit: String,page: String) =ApiServices.getInstance().ProductItemList(product_category_id,limit,page)

    suspend fun getProductDetail(product_id:String) = ApiServices.getInstance().ProductDetail(product_id)
}