package com.example.graduationproject.data.database

import androidx.room.*
import com.example.graduationproject.model.Section
import kotlinx.coroutines.flow.Flow


@Dao
interface SectionsDao {

    @Transaction
    suspend fun updateSections(sections: List<Section>) {
        deleteAll()
        saveOrReplace(sections)
    }

    @Query("DELETE FROM section")
    suspend fun deleteAll()

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveOrReplace(data: List<Section>)

    @Query("SELECT * FROM section")
    fun observeAll(): Flow<List<Section>>

}