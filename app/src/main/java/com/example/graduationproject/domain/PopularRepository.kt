package com.example.graduationproject.domain

import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow

interface PopularRepository {

    fun observePopular(): Flow<List<Popular>>

    suspend fun getPopular(): List<Popular>

    suspend fun refreshPopular()
}