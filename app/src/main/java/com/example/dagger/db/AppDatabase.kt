package com.example.dagger.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.dagger.dao.AppDao
import com.example.dagger.model.RepositoryData
import com.example.dagger.model.TypeConverterOwner

@Database(entities = [RepositoryData::class], version = 1, exportSchema = false)
@TypeConverters(TypeConverterOwner::class)
abstract class AppDatabase : RoomDatabase(){
    abstract fun getAppDao() : AppDao
    companion object{
        private var INSTANCE : AppDatabase? = null

        fun getDbInstance(context: Context): AppDatabase{
            if (INSTANCE==null){
                INSTANCE = Room.databaseBuilder(context.applicationContext,AppDatabase::class.java, "db")
                    .allowMainThreadQueries()
                    .build()
            }
            return INSTANCE!!

        }
    }
}