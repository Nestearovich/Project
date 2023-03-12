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
    @SerializedName("byline")
    var byline: String?=null,
    //val media: List<Media>,
  //  val nytdsection: String,
    @SerializedName("published_date")
    var published_date: String?=null,
    @SerializedName("section")
    var section: String?=null,
    @SerializedName("source")
    var source: String?=null,
    @SerializedName("subsection")
    var subsection: String?=null,
    @SerializedName("title")
    var title: String?=null,
    @SerializedName("type")
    var type: String?=null,
    @SerializedName("updated")
    var updated: String?=null,
    @SerializedName("uri")
    var uri: String?=null,
    @SerializedName("url")
    var url: String?=null
)