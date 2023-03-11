package com.example.graduationproject.domain

import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularInteractor @Inject constructor(
    private val popularRepository: PopularRepository
) {

    fun observePopular(): Flow<List<Popular>> {
        return popularRepository.observePopular()
    }

    suspend fun isDataBaseEmpty(): Boolean {
        return popularRepository.getPopular().isEmpty()
    }

    suspend fun refreshPopular() {
        popularRepository.refreshPopular()
    }
}