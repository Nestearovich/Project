package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "article")
data class Article constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val title: String,
   // val abstract: String,
    val section: String,
    val published_date: String,
    val item_type: String,
    val source: String,
    val thumbnail_standard: String,
    val url: String

)