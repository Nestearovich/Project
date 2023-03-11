package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.PopularDao
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.PopularRepository
import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularRepositoryImpl @Inject constructor(
    private val api:ApiService,
    private val popularDao:PopularDao
) :PopularRepository {

    override fun observePopular(): Flow<List<Popular>> {
      return  popularDao.observeNews()
    }

    override suspend fun getPopular(): List<Popular> {
        return popularDao.getAll()
    }

    override suspend fun refreshPopular() {
        val popular = api.getMostPopular(1).getResultsOrThrow()
        popularDao.updatePopular(popular)
    }
}