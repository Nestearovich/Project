package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.ArticlesDao
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.ArticleRepository
import com.example.graduationproject.model.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val articlesDao: ArticlesDao
) : ArticleRepository {


    override fun observeArticle(sectionName: String): Flow<List<Article>> {
        return articlesDao.observeAll(sectionName)
    }

    override suspend fun refreshArticle(sectionName: String) {
        val articles = apiService.getArticles(sectionName).getResultsOrThrow()
        articlesDao.updateSectionArticles(sectionName, articles)
    }

}