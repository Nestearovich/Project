package com.example.graduationproject.data.database

import androidx.room.*
import com.example.graduationproject.model.Article
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticlesDao {
    @Transaction
    suspend fun updateSectionArticles(section: String?, sectionEntities: List<Article>) {
        deleteAllWithSection(section)
        saveOrReplace(sectionEntities)
    }

    @Query("DELETE FROM article WHERE section LIKE :section")
    suspend fun deleteAllWithSection(section: String?)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrReplace(data: List<Article>)

    @Query("SELECT * FROM article WHERE section LIKE :section ")
    fun observeAll(section: String?): Flow<List<Article>>

}