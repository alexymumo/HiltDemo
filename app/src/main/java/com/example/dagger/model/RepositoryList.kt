package com.example.dagger.model

import androidx.room.Entity

@Entity(tableName = "repositoryList")
data class RepositoryList(val items:List<RepositoryData>)
