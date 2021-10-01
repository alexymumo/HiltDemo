package com.example.dagger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dagger.databinding.ActivityMainBinding
import com.example.dagger.model.RepositoryData
import com.example.dagger.ui.adapter.RecyclerViewAdapter
import com.example.dagger.ui.viewmodel.AppViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
       // setContentView(R.layout.activity_main)
        initViewModel()
        initMainViewModel()

    }
    private fun initViewModel(){
        binding.recyclerView.apply{
            layoutManager = LinearLayoutManager(this@MainActivity)
            val decoration = DividerItemDecoration(applicationContext, DividerItemDecoration.VERTICAL)
            addItemDecoration(decoration)
            recyclerViewAdapter = RecyclerViewAdapter()
            adapter = recyclerViewAdapter

            //adapter here

        }
    }
    private fun initMainViewModel(){
        val viewModel = ViewModelProvider(this).get(AppViewModel::class.java)
        viewModel.getAllRepositoryList().observe(this, Observer<List<RepositoryData>>{
            recyclerViewAdapter.setListData(it)
            recyclerViewAdapter.notifyDataSetChanged()

        })
        viewModel.makeApiCall()

    }
}