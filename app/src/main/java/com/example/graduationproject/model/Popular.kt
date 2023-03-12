package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName


@Entity("popular")
data class Popular constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    @SerializedName("abstract")
    var description: String?=null,
   // val adx_keywords: String,
    var byline: String?=null,
    //val media: List<Media>,
  //  val nytdsection: String,
    var published_date: String?=null,
    var section: String?=null,
    var source: String?=null,
    var subsection: String?=null,
    var title: String?=null,
    var type: String?=null,
    var updated: String?=null,
    var uri: String?=null,
    var url: String?=null
)