package com.example.graduationproject.data.database

import androidx.room.*
import com.example.graduationproject.model.Article
import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow


@Dao
interface SectionsDao {

    @Transaction
    suspend fun updateSections(sectionEntities: List<Section>) {
        deleteAll()
        saveOrReplace(sectionEntities)
    }

    @Query("DELETE FROM sectionEntity")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrReplace(data: List<Section>)

    @Query("SELECT * FROM sectionEntity")
    fun observeAll(): Flow<List<Section>>

    @Transaction
    suspend fun updateNews(articleEntities: List<Article>) {
        deleteAll()
        replace(articleEntities)
    }

    @Query("DELETE FROM article")
    suspend fun deleteNews()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun replace(data: List<Article>)

    @Query("SELECT * FROM article")
    fun observeNews(): Flow <List<Article>>

}