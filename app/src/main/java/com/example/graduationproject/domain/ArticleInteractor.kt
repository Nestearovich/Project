package com.example.graduationproject.domain

import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Favorite
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleInteractor @Inject constructor(
    private val articleRepository: ArticleRepository,
    private val preferences: SharedPreferencesHelper
) {

    fun observeArticle(sectionName: String): Flow<List<Article>> {
        return articleRepository.observeArticle(sectionName)
    }

    suspend fun refreshArticle(sectionName: String) {
        articleRepository.refreshArticle(sectionName)
    }

    suspend fun findItem(searchText: String):Favorite{
        return articleRepository.findItemByDescription(searchText)
    }

    suspend fun onFavClicked(title: String){
        val foundItem =  articleRepository.findItemByDescription(title)
        articleRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): Flow<List<Favorite>>{
        return articleRepository.getFavorites()
    }

}