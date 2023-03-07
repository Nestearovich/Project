package com.example.graduationproject.data.service

import com.example.graduationproject.data.ApiResponseResults
import com.example.graduationproject.model.ArticleEntity
import com.example.graduationproject.model.Section
import com.example.graduationproject.utils.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("content/section-list.json")
    suspend fun getSections(@Query("api-key") key: String = API_KEY): ApiResponseResults<Section>

    @GET("content/all/{section}.json")
    suspend fun getArticles(
        @Path("section") section: String,
        @Query("api-key") key: String = API_KEY
    ): ApiResponseResults<ArticleEntity>

}

