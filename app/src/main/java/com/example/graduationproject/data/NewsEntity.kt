package com.example.graduationproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NewsEntity")
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val section: String,
    val display_name: String
)