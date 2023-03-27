package com.example.graduationproject.domain.items

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

    suspend fun findItem(id: Long):Favorite{
        return articleRepository.findItemByDescription(id)
    }

    suspend fun onFavClicked(id: Long){
        val foundItem =  articleRepository.findItemByDescription(id)
        articleRepository.favClicked(foundItem)
    }

    suspend fun getFavorites(): Flow<List<Favorite>>{
        return articleRepository.getFavorites()
    }

}