package com.example.shoppinglistapp.data.db

import androidx.room.*

@Dao
interface UserDao {


    @Query("SELECT * FROM userinfo ORDER BY id DESC")
    fun getAllUserInfo(): List<UserEntity>?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
   suspend fun insertUser(user: UserEntity?)

   @Delete
   suspend fun deleteUser(user: UserEntity?)

    @Update
   suspend fun updateUser(user: UserEntity?)

}