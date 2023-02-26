package com.example.graduationproject.data

import com.google.gson.annotations.SerializedName

data class NewsResponse(
    @SerializedName("results")
    val results: List<NewsEntity>,
    @SerializedName("status")
    val status: String,
    @SerializedName("copyright")
    val copyright: String,
    @SerializedName("num_results")
    val num_results: Int,

)
