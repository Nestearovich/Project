package com.example.graduationproject.apers

data class News(
    val copyright: String,
    val num_results: Int,
    val results: List<Result>,
    val status: String
)