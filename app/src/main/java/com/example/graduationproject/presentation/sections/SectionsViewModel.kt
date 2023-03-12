package com.example.graduationproject.presentation.sections

import android.util.Log
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

    init {
        viewModelScope.launch {
            if (sectionsInteractor.isDataBaseEmpty()) {
                update()
            }
        }
    }

    fun update() {
        viewModelScope.launch {
            isLoading.value = true
            try {
                sectionsInteractor.refreshSections()
            } catch (e: Exception) {
                Log.w("error update",toString())
            }
            isLoading.value = false
        }
    }

}