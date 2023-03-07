package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.SectionsDao
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.ArticleRepository
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val sectionsDao: SectionsDao
) : ArticleRepository {

    override fun observeArticle(): Flow <List<Article>> {
        return sectionsDao.observeNews()
    }

    override suspend fun refreshArticle() {
        val article = apiService.getArticles("books").getResultsOrThrow()
        println(article)
        sectionsDao.replace(article)
    }

}