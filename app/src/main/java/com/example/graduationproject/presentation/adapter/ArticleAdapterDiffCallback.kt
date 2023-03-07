package com.example.graduationproject.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.graduationproject.model.ArticleEntity

class ArticleAdapterDiffCallback : DiffUtil.ItemCallback<ArticleEntity>() {

    override fun areItemsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: ArticleEntity, newItem: ArticleEntity): Boolean {
        return oldItem == newItem
    }

}