package com.example.graduationproject.domain

import com.example.graduationproject.data.NewsResponse
import retrofit2.Response
import javax.inject.Inject

interface NewsRepository {

    suspend fun getNews(): Response<NewsResponse>
}