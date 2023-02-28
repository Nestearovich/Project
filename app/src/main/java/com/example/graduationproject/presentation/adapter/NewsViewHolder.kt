package com.example.graduationproject.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.graduationproject.R
import com.example.graduationproject.model.NewsModel
import com.example.graduationproject.presentation.adapter.listener.NewsListener

class NewsViewHolder(
    private val view: View,
    private val newsListener: NewsListener
): RecyclerView.ViewHolder(view) {

    fun bind(newsModel: NewsModel) {
        val name = view.findViewById<TextView>(R.id.newsText)
        val imageView = view.findViewById<ImageView>(R.id.newsImage)


    }
}