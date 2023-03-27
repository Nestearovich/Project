package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.ArticlesDao
import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.domain.items.FavoriteRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FavoriteRepositoryImpl @Inject constructor (
    private val articlesDao: ArticlesDao,
        ):FavoriteRepository {
    override suspend fun deleteFavoriteById(id: Long) {
        withContext(Dispatchers.IO) {
            articlesDao.deleteFavoriteEntityById(id)
        }
    }
}