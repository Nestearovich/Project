package com.example.graduationproject.domain.items

import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Favorite
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    fun observeArticle(sectionName: String): Flow<List<Article>>

    suspend fun refreshArticle(sectionName: String)

    suspend fun findItemByDescription(id: Long): Favorite

    suspend fun favClicked(favorite: Favorite)

    suspend fun getFavorites(): Flow<List<Favorite>>
}