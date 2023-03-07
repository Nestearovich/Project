package com.example.graduationproject.data.response

import com.google.gson.annotations.SerializedName

data class ArticleModel(
    @SerializedName("id")
    val id: Long = 0,
    @SerializedName("title")
    val title: String,
    @SerializedName("section")
    val section: String,
    @SerializedName("published_date")
    val published_date: String,
    @SerializedName("item_type")
    val item_type: String,
    @SerializedName("source")
    val source: String,
)
