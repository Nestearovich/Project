package com.example.graduationproject.di

import android.content.Context
import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.utils.Constant.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
class DataApiModule {

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun provideSharedPrefences(
        @ApplicationContext context: Context
    ): SharedPreferencesHelper{
        return SharedPreferencesHelper(
            context.getSharedPreferences(SP_KEY, Context.MODE_PRIVATE)
        )
        }
    companion object{
        private const val SP_KEY = "SP_KEY"
    }


}