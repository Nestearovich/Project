package com.example.graduationproject.domain.items

import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SectionsInteractor @Inject constructor(
    private val sectionsRepository: SectionsRepository
) {

    fun observeSections(): Flow<List<Section>> {
        return sectionsRepository.observeSections()
    }

    suspend fun isDataBaseEmpty(): Boolean {
        return sectionsRepository.getSections().isEmpty()
    }

    suspend fun refreshSections() {
        sectionsRepository.refreshSections()
    }

    suspend fun logoutUser(){
        sectionsRepository.logoutUser()
    }

}