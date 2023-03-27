package com.example.graduationproject.domain.items

import javax.inject.Inject

class FavoriteInteractor @Inject constructor(
    private val favoriteRepository: FavoriteRepository
) {

    suspend fun deleteFavItemById(id: Long) {
        favoriteRepository.deleteFavoriteById(id)
    }

}