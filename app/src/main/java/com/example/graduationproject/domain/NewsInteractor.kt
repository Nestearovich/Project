package com.example.graduationproject.domain

import com.example.graduationproject.data.NewsResponse
import retrofit2.Response
import javax.inject.Inject

class NewsInteractor @Inject constructor(
    private val newsRepository: NewsRepository
) {
    suspend fun getNews():Response<NewsResponse>{
        return newsRepository.getNews()
    }

}