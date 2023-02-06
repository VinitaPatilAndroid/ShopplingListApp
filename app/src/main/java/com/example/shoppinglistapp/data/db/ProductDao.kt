package com.example.shoppinglistapp.data.db

import androidx.room.*
import com.example.shoppinglistapp.data.model.ProductItemResponse

@Dao
interface ProductDao {

    @Query("SELECT * FROM productinfo ORDER BY id DESC")
    fun getAllProductInfo(): List<ProductItemResponse>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertProduct(product: ProductItemResponse?)

   @Delete
    fun deleteProduct(product: ProductItemResponse?)

}