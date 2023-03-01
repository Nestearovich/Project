package com.example.graduationproject.di

import android.content.Context
import com.example.graduationproject.data.database.AppDataBase
import com.example.graduationproject.data.database.SectionsDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Provides
    fun provideItemsDao(newsDataBase: AppDataBase): SectionsDao {
        return newsDataBase.getSectionsDao()
    }

    @Provides
    fun provideAppDataBase(context: Context): AppDataBase {
        return AppDataBase.getItemsDatabaseInstance(context)
    }

}