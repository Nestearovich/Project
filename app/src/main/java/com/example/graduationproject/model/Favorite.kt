package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity("favorite")
data class Favorite constructor(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var title: String?=null,
    @SerializedName("abstract")
    var description: String?=null,
    var section: String?=null,
    var published_date: String?=null,
    var item_type: String?=null,
    var source: String?=null,
    var thumbnail_standard: String?=null,
    var url: String?=null
)
