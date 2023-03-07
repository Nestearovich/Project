package com.example.graduationproject.presentation.sections

import androidx.lifecycle.*
import com.example.graduationproject.R
import com.example.graduationproject.domain.SectionsInteractor
import com.example.graduationproject.presentation.listener.NewsListener
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SectionsViewModel @Inject constructor(
    private val sectionsInteractor: SectionsInteractor,

) : ViewModel() {

    val isLoading = MutableLiveData(false)
    val items = sectionsInteractor.observeSections().asLiveData()

    private val _bundle = MutableLiveData<NavigateWithBundle?>()
    val bundle: LiveData<NavigateWithBundle?> = _bundle

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
    fun userNavigated() {
        _bundle.value = null
    }

     fun elementClicked(section: String?, displayName: String?) {
        _bundle.value = NavigateWithBundle(
            section , displayName,  R.id.action_sectionsFragment_to_articleFragment
        )
    }

}

data class NavigateWithBundle(
    val section: String?,
    val displayName: String?,
    val destinationId: Int
)