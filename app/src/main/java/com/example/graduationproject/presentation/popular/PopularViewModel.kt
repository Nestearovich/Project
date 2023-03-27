package com.example.graduationproject.presentation.popular

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.domain.items.PopularInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PopularViewModel @Inject constructor(
    private val popularInteractor: PopularInteractor,
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val items = popularInteractor.observePopular() .asLiveData()

   init {
       viewModelScope.launch {
           try {
               popularInteractor.refreshIfNeed()
           }catch (e:Exception){

           }
       }
   }

    fun update() {
            viewModelScope.launch {
                isLoading.value = true
                try {
                    popularInteractor.refreshPopular()
                } catch (e: Exception) {
                    Log.w("error update",toString())
                }
                isLoading.value = false
            }
    }
}
