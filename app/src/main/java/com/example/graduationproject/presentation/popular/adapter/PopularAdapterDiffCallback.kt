package com.example.graduationproject.presentation.popular.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Popular

class PopularAdapterDiffCallback: DiffUtil.ItemCallback<Popular>() {
    override fun areItemsTheSame(oldItem: Popular, newItem: Popular): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Popular, newItem: Popular): Boolean {
        return oldItem == newItem
    }
}