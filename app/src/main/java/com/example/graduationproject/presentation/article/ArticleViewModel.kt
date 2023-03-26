package com.example.graduationproject.presentation.article

import android.util.Log
import androidx.lifecycle.*
import com.example.graduationproject.domain.ArticleInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    state: SavedStateHandle,
    private val articleInteractor: ArticleInteractor,
) : ViewModel() {

    private val section: String = state[ArticleFragment.SECTION_KEY]!!

    val isLoading = MutableLiveData(false)
    val items = articleInteractor.observeArticle(section).asLiveData()

    fun update() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                articleInteractor.refreshArticle(section)
            } catch (e: Exception) {
              Log.w("error update",toString())
            }
            isLoading.value = false
        }
    }
    fun onFavClicked(title: String){
        viewModelScope.launch {
            try {
                articleInteractor.onFavClicked(title)
            }catch (e: Exception){
                Log.w("News fav clicked", e.message.toString())
            }

        }
    }

}