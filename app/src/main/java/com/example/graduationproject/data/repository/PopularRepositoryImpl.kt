package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.PopularDao
import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.items.PopularRepository
import com.example.graduationproject.model.Popular
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
    private val api:ApiService,
    private val popularDao:PopularDao,
    private val preferences: SharedPreferencesHelper
) : PopularRepository {

    override fun observePopular(): Flow<List<Popular>> {
      return  popularDao.observeNews()
    }

    override suspend fun getPopular(): List<Popular> {
        return withContext(Dispatchers.IO) {
             popularDao.getAll()
        }
    }

    override suspend fun refreshPopular() {
        return withContext(Dispatchers.IO) {
            val popular = api.getMostPopular(1).getResultsOrThrow()
            popularDao.updatePopular(popular)
        }
    }
}