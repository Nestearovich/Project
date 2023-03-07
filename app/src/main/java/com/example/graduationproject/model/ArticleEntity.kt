package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "articleEntity")
data class ArticleEntity constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
    val section: String,
    val published_date: String,
    val item_type: String,
    val source: String,
)