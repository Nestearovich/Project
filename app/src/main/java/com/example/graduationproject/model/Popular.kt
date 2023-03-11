package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity("popular")
data class Popular constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
   // val `abstract`: String,
   // val adx_keywords: String,
    val byline: String?,
    //val media: List<Media>,
  //  val nytdsection: String,
    val published_date: String?,
    val section: String?,
    val source: String?,
    val subsection: String?,
    val title: String?,
    val type: String?,
    val updated: String?,
    val uri: String?,
    val url: String?
)