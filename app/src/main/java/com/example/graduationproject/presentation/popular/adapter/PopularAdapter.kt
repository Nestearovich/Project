package com.example.graduationproject.presentation.popular.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.R
import com.example.graduationproject.databinding.ItemArticleBinding
import com.example.graduationproject.databinding.NewsItemLayoutBinding
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Popular
import com.example.graduationproject.presentation.article.adapter.ArticleAdapter
import com.example.graduationproject.presentation.listener.PopListener

class PopularAdapter(
    private val listener: PopListener
) : ListAdapter<Popular, PopularAdapter.PopularViewHolder>(PopularAdapterDiffCallback()) {

    class PopularViewHolder(val binding: NewsItemLayoutBinding, private val listener: PopListener) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(popular: Popular) {
            itemView.setOnClickListener {
                listener.onClick(
                    popular
                )
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val binding = NewsItemLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PopularViewHolder(binding, listener)
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.tvTitle.text = item.title
        holder.binding.tvDate.text = item.updated
        holder.binding.tvAbstract.text = item.description
        holder.bind(item)
    }

}