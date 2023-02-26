package com.example.graduationproject.di

import com.example.graduationproject.domain.NewsInteractor
import com.example.graduationproject.domain.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DomainModule {
    @Provides
    fun provideNewsInteractor(
        newsRepository: NewsRepository
    ): NewsInteractor {
        return NewsInteractor(newsRepository)
    }
}