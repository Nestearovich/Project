package com.example.graduationproject.data.database

import androidx.room.*
import com.example.graduationproject.model.Popular
import kotlinx.coroutines.flow.Flow


@Dao
interface PopularDao {

    @Transaction
    suspend fun updatePopular(popular: List<Popular>) {
        deleteAll()
        insertItem(popular)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(data: List<Popular>)

    @Query("SELECT * FROM popular")
    fun observeNews(): Flow<List<Popular>>

    @Query("SELECT * FROM popular")
    suspend fun getAll(): List<Popular>

    @Query("DELETE FROM popular")
    suspend fun deleteAll()
}