package com.example.shoppinglistapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.demo.roomdemo.Convertors


@Database(entities = [UserEntity::class], version = 3)
@TypeConverters(Convertors::class)
abstract class RoomAppDb: RoomDatabase() {

    abstract fun userDao(): UserDao?

    companion object{

        // Create migration object add sql query
        val migration_2_3 = object :Migration(2,3){
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE userinfo ADD COLUMN isActive INTEGER NOT NULL DEFAULT(1)")
            }
        }

        //our instance variable assign any value so every thred know that
        // this value will be updated
        // instance varable ki value assign hogi tab sare thread ko smjme ayega ki
        // value updated this is use of volatile
        @Volatile
        // create instance of app database
        private var INSTANCE : RoomAppDb? = null

        fun getDatabase(context:Context):RoomAppDb{
            val tempInstance = INSTANCE

            // current instance not null return the exiting instace of that
            // particular class and get context as a an argument
            if (tempInstance != null){
                return tempInstance
            }

            // create a new instances do below process
            // sysnchronized keywork = if it's call from three diffrent
            // places then all the operation are not executed at single point
            // of time 1st it's read for single operation can be compaleted
            // then next thread can carry out simillary opearation some for all
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    RoomAppDb::class.java,"app_database")
                        // add migration object in room object
                    .addMigrations(migration_2_3)
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

   /* companion object {
        private var INSTANCE: RoomAppDb?= null

        val migration_1_2: Migration = object: Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE userinfo ADD COLUMN phone TEXT DEFAULT ''")
            }
        }

        fun getAppDatabase(context: Context): RoomAppDb? {

            if(INSTANCE == null ) {

                INSTANCE = Room.databaseBuilder<RoomAppDb>(
                    context.applicationContext, RoomAppDb::class.java, "AppDBB"
                )
                    .addMigrations(migration_1_2)
                    .allowMainThreadQueries()
                    .build()

            }
            return INSTANCE
        }
        fun destroyInstance() {
            INSTANCE = null
        }
    }*/
}