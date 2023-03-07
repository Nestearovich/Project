package com.example.graduationproject.domain

import com.example.graduationproject.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleInteractor @Inject constructor(
    private val articleRepository: ArticleRepository
) {

    fun observeArticle(): Flow< List<Article>> {
        return articleRepository.observeArticle()
    }

    suspend fun refreshArticle() {
       articleRepository.refreshArticle()
    }

}