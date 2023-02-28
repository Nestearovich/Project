package com.example.graduationproject.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.R
import com.example.graduationproject.data.NewsEntity
import com.example.graduationproject.model.NewsModel
import com.example.graduationproject.presentation.adapter.listener.NewsListener

class NewsAdapter(
    private val news: List<NewsModel>,
    private val newsListener: NewsListener
) : RecyclerView.Adapter<NewsViewHolder>() {

//    private val callBack = object : DiffUtil.ItemCallback<NewsEntity>(){
//        override fun areItemsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
//            return oldItem.url == newItem.url
//        }
//
//        override fun areContentsTheSame(oldItem: NewsEntity, newItem: NewsEntity): Boolean {
//            return oldItem == newItem
//        }
//    }

   // val differ = AsyncListDiffer(this,callBack)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
       val new = LayoutInflater.from(parent.context).inflate(R.layout.item_details,parent,false)
           return NewsViewHolder(new,newsListener)
    }

    override fun getItemCount(): Int {
        return  news.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])
    }

}