package com.example.graduationproject.presentation.popular.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.databinding.NewsItemLayoutBinding
import com.example.graduationproject.model.Popular

class PopularAdapter:RecyclerView.Adapter<PopularAdapter.PopularViewHolder>() {

     class PopularViewHolder( val binding: NewsItemLayoutBinding):RecyclerView.ViewHolder(binding.root){

    }

    private val callback = object :DiffUtil.ItemCallback<Popular>(){
        override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return oldItem.url == newItem.url
        }

        override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
            return oldItem ==newItem
        }
    }

    val differ = AsyncListDiffer(this,callback)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return  PopularViewHolder(
            NewsItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val popular = differ.currentList[position]
       holder.binding.tvMostNewsTitle.text = popular.title
    }

    private var onItemClickListener:((Popular)->Unit)? = null

    fun setOnItemClickListener(listener:(Popular)->Unit){
        onItemClickListener = listener
    }

}