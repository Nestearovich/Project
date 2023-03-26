package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.ArticlesDao
import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.ArticleRepository
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Favorite
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val articlesDao: ArticlesDao,
    private val preferences:SharedPreferencesHelper
) : ArticleRepository {


    override fun observeArticle(sectionName: String): Flow<List<Article>> {
        return articlesDao.observeAll(sectionName)
    }

    override suspend fun refreshArticle(sectionName: String) {
       return withContext(Dispatchers.IO) {
            val articles = apiService.getArticles(sectionName).getResultsOrThrow()
            articlesDao.updateSectionArticles(sectionName, articles)
        }
    }

    override suspend fun findItemByDescription(title: String): Favorite {
        return withContext(Dispatchers.IO){
            val favorite = articlesDao.findItemEntityByDescription(title)
            Favorite(favorite.id,favorite.title,favorite.description)
        }
    }

    override suspend fun favClicked(favorite: Favorite) {
        return withContext(Dispatchers.IO){
            articlesDao.insertFavoritesEntity(
                Favorite(
                   favorite.id,
                    favorite.title,
                    favorite.thumbnail_standard,
                    favorite.description,
                    favorite.url
                   )
            )
        }
    }

    override suspend fun getFavorites(): Flow<List<Favorite>> {
        return withContext(Dispatchers.IO){
            articlesDao.getFavoriteEntities()
        }
    }
}