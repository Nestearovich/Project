package com.example.graduationproject.data.repository

import com.example.graduationproject.data.database.SectionsDao
import com.example.graduationproject.data.service.ApiService
import com.example.graduationproject.domain.SectionsRepository
import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class SectionsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val sectionsDao: SectionsDao
) : SectionsRepository {

    override fun observeSections(): Flow<List<Section>> {
        return sectionsDao.observeAll()
    }

    override suspend fun getSections(): List<Section> {
        return sectionsDao.getAll()
    }

    override suspend fun refreshSections() {
        val sections = apiService.getSections().getResultsOrThrow()
        println(sections)
        sectionsDao.updateSections(sections)
    }

}