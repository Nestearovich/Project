package com.example.graduationproject.presentation.favorite.adapter

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.graduationproject.databinding.ItemFavoriteBinding
import com.example.graduationproject.model.Favorite

class FavoriteViewHolder(
    private val binding: ItemFavoriteBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(favorite: Favorite){
        val image = binding.imageView
        binding.tvAbstract.text = favorite.description
        binding.tvDate.text = favorite.published_date
        binding.articleText.text = favorite.title
        Glide.with(itemView.context).load(favorite.thumbnail_standard).into(image)
    }
}