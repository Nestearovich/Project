package com.example.graduationproject.presentation.favorite

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.R
import com.example.graduationproject.domain.items.ArticleInteractor
import com.example.graduationproject.domain.items.FavoriteInteractor
import com.example.graduationproject.model.Favorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favInteractor: ArticleInteractor,
    private val favoriteInteractor: FavoriteInteractor
): ViewModel() {

    private val _favorites = MutableLiveData<List<Favorite>>()
    val favorites = _favorites


    fun getFavorites(){
        viewModelScope.launch {
            try {
                val favoritesItems = favInteractor.getFavorites()
                favoritesItems.collect{listFavorite ->
                    _favorites.value = listFavorite
                }

            }catch (e:java.lang.Exception){
                Log.w("fav error",e.toString())
            }
        }
    }
    fun deleteFavorite(id: Long) {
        viewModelScope.launch {
            try {
                favoriteInteractor.deleteFavItemById(id)
            } catch (e: Exception) {

            }
        }
    }
}