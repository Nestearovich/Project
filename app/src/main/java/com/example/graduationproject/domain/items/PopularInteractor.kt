package com.example.graduationproject.domain.items

import com.example.graduationproject.data.prefer.SharedPreferencesHelper
import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PopularInteractor @Inject constructor(
    private val popularRepository: PopularRepository,
    private val preferences: SharedPreferencesHelper
) {

    fun observePopular(): Flow<List<Popular>> {
        return popularRepository.observePopular()
    }

//    suspend fun isDataBaseEmpty(): Boolean {
//        return popularRepository.getPopular().isEmpty()
//    }

    suspend fun refreshIfNeed () {
        val lastDate = preferences . getLastDate ()
        val isOutdated = lastDate - 400000 < System.currentTimeMillis()
        if(isOutdated) {
            refreshPopular()
        }else {}
    }

    suspend fun refreshPopular() {
        popularRepository.refreshPopular()
        preferences.updateLastDate(System.currentTimeMillis())
    }
    fun getLastDate():Long{
        return preferences.getLastDate()
    }
    fun updateLastDate(date:Long) {
        return preferences.updateLastDate(date)
    }
}