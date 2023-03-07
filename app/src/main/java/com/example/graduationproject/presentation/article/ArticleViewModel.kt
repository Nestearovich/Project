package com.example.graduationproject.presentation.article

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.domain.ArticleInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleInteractor: ArticleInteractor,
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val items = articleInteractor.observeArticle().asLiveData()

    fun update() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                articleInteractor.refreshArticle()
            } catch (e: Exception) {
                // обработать ошибку
            }
            isLoading.value = false
        }
    }

}