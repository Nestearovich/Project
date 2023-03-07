package com.example.graduationproject.domain

import com.example.graduationproject.model.ArticleEntity
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun observeArticle(): Flow <List<ArticleEntity>>

    suspend fun refreshArticle()
}