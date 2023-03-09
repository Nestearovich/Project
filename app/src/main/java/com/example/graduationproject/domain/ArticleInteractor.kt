package com.example.graduationproject.domain

import com.example.graduationproject.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleInteractor @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    fun observeArticle(sectionName: String): Flow<List<Article>> {
        return articleRepository.observeArticle(sectionName)
    }

    suspend fun refreshArticle(sectionName: String) {
        articleRepository.refreshArticle(sectionName)
    }

}