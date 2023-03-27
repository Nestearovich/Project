package com.example.graduationproject.presentation.sections

import android.util.Log
import androidx.lifecycle.*
import com.example.graduationproject.R
import com.example.graduationproject.domain.items.SectionsInteractor
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SectionsViewModel @Inject constructor(
    private val sectionsInteractor: SectionsInteractor,
) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val items = sectionsInteractor.observeSections().asLiveData()

    private val _logoutUser = MutableLiveData<Int?>()
    val logoutUser: LiveData<Int?> = _logoutUser
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

    fun logOutUser() {
        viewModelScope.launch {
            sectionsInteractor.logoutUser()
            _logoutUser.value = R.navigation.auth_graph

        }
    }
}