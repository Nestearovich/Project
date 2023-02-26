package com.example.graduationproject.data.database

import androidx.room.Dao
import androidx.room.Insert
import com.example.graduationproject.data.NewsEntity


@Dao
interface NewsDao {


    @Insert
    suspend fun insertNewsEntity(newsEntity: NewsEntity)

}