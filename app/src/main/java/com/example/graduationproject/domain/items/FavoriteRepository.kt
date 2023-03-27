package com.example.graduationproject.domain.items

interface FavoriteRepository {

    suspend fun deleteFavoriteById(id: Long)


}