package com.example.graduationproject.di

import com.example.graduationproject.data.repository.SectionsRepositoryImpl
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.SectionsRepository
import com.example.graduationproject.utils.Constant.BASE_URL
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module
@InstallIn(SingletonComponent::class)
abstract class DataRepositoryModule {

    @Binds
    abstract fun bindSectionsRepository(impl: SectionsRepositoryImpl): SectionsRepository


}