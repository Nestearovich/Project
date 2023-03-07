package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.SectionsDao
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.ArticleRepository
import com.example.graduationproject.model.ArticleEntity
import com.example.graduationproject.utils.Constant.API_KEY
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val sectionsDao: SectionsDao
) : ArticleRepository {

    override fun observeArticle(): Flow <List<ArticleEntity>> {
        return sectionsDao.observeNews()
    }

    override suspend fun refreshArticle() {
        val article = apiService.getArticles(API_KEY).getResultsOrThrow()
        println(article)
        sectionsDao.replace(article)
    }

}