package com.example.graduationproject.presentation.article.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.databinding.ItemArticleBinding
import com.example.graduationproject.model.Article
import com.example.graduationproject.presentation.listener.Listener

class ArticleAdapter(
    private val listener: Listener
) :
    ListAdapter<Article, ArticleAdapter.ViewHolder>(ArticleAdapterDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ViewHolder(binding,listener)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.articleText.text = item.title
        holder.binding.tvAbstract.text = item.description
        Glide.with(holder.itemView.context).load(item.thumbnail_standard).into(holder.image)
        holder.bind(item)
    }

    class ViewHolder(val binding: ItemArticleBinding,private val listener: Listener) : RecyclerView.ViewHolder(binding.root){
        val image = binding.imageView

        fun bind(article: Article){
            itemView.setOnClickListener {
                listener.onClick(
                    article
                )
            }
        }
    }


}