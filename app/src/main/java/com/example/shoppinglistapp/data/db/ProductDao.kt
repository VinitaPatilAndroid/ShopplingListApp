package com.example.shoppinglistapp.data.db

import androidx.room.*
import com.example.shoppinglistapp.data.entity.response.ProductItemResponse

@Dao
interface ProductDao {

    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllProductInfo(): List<ProductItemResponse>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(user: ProductItemResponse?)

   @Delete
    fun deleteUser(user: ProductItemResponse?)

}