package com.example.graduationproject.data.response

import com.google.gson.annotations.SerializedName

data class ArticleResponse(
@SerializedName("article")
val article: List<ArticleModel>
)
