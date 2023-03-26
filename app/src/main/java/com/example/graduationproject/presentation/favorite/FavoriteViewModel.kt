package com.example.graduationproject.presentation.favorite

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.domain.ArticleInteractor
import com.example.graduationproject.model.Favorite
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(
    private val favInteractor: ArticleInteractor
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
}