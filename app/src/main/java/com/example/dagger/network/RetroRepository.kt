package com.example.dagger.network

import androidx.lifecycle.LiveData
import com.example.dagger.dao.AppDao
import com.example.dagger.model.RepositoryData
import com.example.dagger.model.RepositoryList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

/*make a api call and stores the data inside the room database
* */
class RetroRepository @Inject constructor(private val retrofitService: RetrofitService, private val appDao: AppDao){
    fun getAllRecords() : LiveData<List<RepositoryData>> {
        return appDao.getAllRecords()
    }
    fun insertRecord(repositoryData: RepositoryData){
        appDao.insertRecord(repositoryData)
    }

    //get data from github
    fun makeApiCall(query:String?){
        val call:Call<RepositoryList> = retrofitService.getDataFromAPI(query!!)
        call.enqueue(object : Callback<RepositoryList>{
            override fun onResponse(
                call: Call<RepositoryList>,
                response: Response<RepositoryList>
            ) {
                if (response.isSuccessful){
                    appDao.deleteAllRecords()
                    response.body()?.items?.forEach{
                        insertRecord(it)
                    }
                }
            }
            override fun onFailure(call: Call<RepositoryList>, t: Throwable) {

            }
        })

    }
}