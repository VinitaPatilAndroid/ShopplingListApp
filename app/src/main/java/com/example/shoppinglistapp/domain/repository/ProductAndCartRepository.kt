package com.example.shoppinglistapp.domain.repository

import com.example.shoppinglistapp.data.networkservices.ApiServices

class ProductListRepository {

    suspend fun getProductList(product_category_id: String,limit: String,page: String) =ApiServices.getInstance().ProductItemList(product_category_id,limit,page)
}