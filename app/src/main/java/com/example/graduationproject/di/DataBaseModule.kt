package com.example.graduationproject.di

import android.content.Context
import com.example.graduationproject.data.database.NewsDao
import com.example.graduationproject.data.database.NewsDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {
    @Provides
    fun provideItemsDao(newsDataBase: NewsDataBase):NewsDao{
        return newsDataBase.getNewsDao()
    }

    @Provides
    fun newsDatabase(context: Context): NewsDataBase{
        return NewsDataBase.getItemsDatabaseInstance(context)
    }
}