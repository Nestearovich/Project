package com.example.graduationproject.data.service

import com.example.graduationproject.utils.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/content.json")
    suspend fun getNews(

        @Query("api-key") key: String = API_KEY)

}

