package com.example.dagger.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.dagger.model.RepositoryData
import com.example.dagger.network.RetroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(private val repository: RetroRepository) : ViewModel(){
    fun getAllRepositoryList(): LiveData<List<RepositoryData>> {
        return repository.getAllRecords()
    }
    fun makeApiCall(){
        repository.makeApiCall("ny")
    }
}