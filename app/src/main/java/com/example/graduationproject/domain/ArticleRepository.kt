package com.example.graduationproject.domain

import com.example.graduationproject.model.Article
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun observeArticle(): Flow <List<Article>>

    suspend fun refreshArticle()
}