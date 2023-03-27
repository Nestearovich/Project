package com.example.graduationproject.di

import com.example.graduationproject.data.repository.*
import com.example.graduationproject.domain.auth.AuthRepository
import com.example.graduationproject.domain.items.ArticleRepository
import com.example.graduationproject.domain.items.FavoriteRepository
import com.example.graduationproject.domain.items.PopularRepository
import com.example.graduationproject.domain.items.SectionsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class DataRepositoryModule {

    @Binds
    abstract fun bindSectionsRepository(impl: SectionsRepositoryImpl): SectionsRepository

    @Binds
    abstract fun bindArticleRepository(impl: ArticleRepositoryImpl): ArticleRepository

    @Binds
    abstract fun bindPopularRepository(impl: PopularRepositoryImpl): PopularRepository

    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Binds
    abstract fun bindFavoriteRepository(impl: FavoriteRepositoryImpl): FavoriteRepository



}