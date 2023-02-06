package com.example.shoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglistapp.data.entity.response.ProductItemResponse


@Database(entities = [ProductItemResponse::class], version = 1)
abstract class RoomAppDb: RoomDatabase() {

    abstract fun productDao(): ProductDao?

    companion object{

        @Volatile
        private var INSTANCE : RoomAppDb? = null

        fun getDatabase(context:Context):RoomAppDb{
            val tempInstance = INSTANCE

            if (tempInstance != null){
                return tempInstance
            }

            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomAppDb::class.java,"app_database")
                        // add migration object in room object
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}