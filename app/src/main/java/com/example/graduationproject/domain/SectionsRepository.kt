package com.example.graduationproject.domain

import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow


interface SectionsRepository {

    fun observeSections(): Flow<List<Section>>

    suspend fun getSections(): List<Section>

    suspend fun refreshSections()

}