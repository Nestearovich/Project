package com.example.graduationproject.data

import com.example.graduationproject.data.database.NewsDao
import com.example.graduationproject.data.service.ApiService
import javax.inject.Inject

class NewsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val newsDao: NewsDao
) {
}