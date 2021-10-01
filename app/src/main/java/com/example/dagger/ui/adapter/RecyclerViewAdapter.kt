package com.example.dagger.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dagger.R
import com.example.dagger.model.RepositoryData

class RecyclerViewAdapter():RecyclerView.Adapter<RecyclerViewAdapter.AppViewHolder>() {
    private var listData:List<RepositoryData>? = null
    fun setListData(listData:List<RepositoryData>?){
        this.listData = listData
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.AppViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.reposotory_list,parent)
        return AppViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.AppViewHolder, position: Int) {
         holder.bind(listData?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listData == null)return 0
        return listData?.size!!
    }
    class AppViewHolder(view : View): RecyclerView.ViewHolder(view) {
        val tvimage= view.tvimage
        val tvname = view.tvname
        val tvdescription = view.tvdescription

        fun bind(data: RepositoryData){
            tvname.text = data.name
            tvdescription.text = data.description


            Glide.with(image_avatar)
                .load(data.owner?.avatar_url)
                .into(image_avatar)

        }

    }
}