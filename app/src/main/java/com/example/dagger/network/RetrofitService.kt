package com.example.dagger.network

import com.example.dagger.model.RepositoryList
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("repositories")
    fun getDataFromAPI(@Query("q")query: String) : retrofit2.Call<RepositoryList>
}