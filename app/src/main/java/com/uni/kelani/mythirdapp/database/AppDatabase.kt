package com.uni.kelani.mythirdapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.uni.kelani.mythirdapp.model.Locations

@Database(entities = [Locations::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationsDao(): LocationsDao
    
    companion object{

        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "locations"
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                instance
            }
        }
    }
}