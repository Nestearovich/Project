package com.example.graduationproject.data

data class NewsResponse(
    val copyright: String,
    val num_results: Int,
    val results: List<NewsEntity>,
    val status: String

)
