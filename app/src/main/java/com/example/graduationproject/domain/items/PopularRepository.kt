package com.example.graduationproject.domain.items

import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow

interface PopularRepository {

    fun observePopular(): Flow<List<Popular>>

    suspend fun getPopular(): List<Popular>

    suspend fun refreshPopular()
}