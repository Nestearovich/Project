package com.example.graduationproject.data.service

import com.example.graduationproject.data.ApiResponseResults
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Popular

import com.example.graduationproject.model.Section
import com.example.graduationproject.utils.Constant.API_KEY
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("news/v3/content/section-list.json")
    suspend fun getSections(@Query("api-key") key: String = API_KEY): ApiResponseResults<Section>

    @GET("news/v3/content/all/{section}.json")
    suspend fun getArticles(
        @Path("section") article: String,
        @Query("api-key") key: String = API_KEY
    ): ApiResponseResults<Article>

    @GET("mostpopular/v2/viewed/{period}.json")
    suspend fun getMostPopular(
        @Path("period") period:Int,
        @Query("api-key")key : String = API_KEY
    ):ApiResponseResults<Popular>
}

