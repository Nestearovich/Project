package com.example.graduationproject.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.graduationproject.model.Article

class ArticleAdapterDiffCallback : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }

}