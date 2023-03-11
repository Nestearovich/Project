package com.example.graduationproject.presentation.popular

import android.provider.SyncStateContract.Helpers.update
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.domain.PopularInteractor
import com.example.graduationproject.domain.SectionsInteractor
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
            if (popularInteractor.isDataBaseEmpty()) {
                update()
            }
        }
    }

    fun update() {
            viewModelScope.launch {
                isLoading.value = true
                try {
                    popularInteractor.refreshPopular()
                } catch (e: Exception) {
                    // обработать ошибку
                }
                isLoading.value = false
            }
    }
}
