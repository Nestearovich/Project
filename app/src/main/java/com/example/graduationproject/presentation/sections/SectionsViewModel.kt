package com.example.graduationproject.presentation.sections

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.graduationproject.domain.SectionsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SectionsViewModel @Inject constructor(
    private val sectionsInteractor: SectionsInteractor,
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val items = sectionsInteractor.observeSections().asLiveData()

    fun update() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                sectionsInteractor.refreshSections()
            } catch (e: Exception) {
                // обработать ошибку
            }
            isLoading.value = false
        }
    }

}