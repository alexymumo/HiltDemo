package com.example.dagger.di

import android.content.Context
import com.example.dagger.dao.AppDao
import com.example.dagger.db.AppDatabase
import com.example.dagger.network.RetrofitService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    val BASE_URL = "https://api.github.com/search/"

    @Provides
    @Singleton
    fun getAppDatabase(context: Context): AppDatabase{
        return AppDatabase.getDbInstance(context)
    }

    @Provides
    @Singleton
    fun getAppDao(appDatabase: AppDatabase): AppDao{
        return appDatabase.getAppDao()
    }

    @Provides
    @Singleton
    fun getRetrofitInstance(retrofit: Retrofit):RetrofitService{
        return  retrofit.create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun getRetrofitServiceInstance(): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}