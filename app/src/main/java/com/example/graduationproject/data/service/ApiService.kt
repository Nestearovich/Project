package com.example.graduationproject.data.service

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("content/section-list.json")
    suspend fun getNews(@Query("api-key") key: String = API_KEY)

    companion object{
        private const val API_KEY = "jDz7q20x9GyNAxbt5ApzqaiSm4fuDFaE"
    }
}

