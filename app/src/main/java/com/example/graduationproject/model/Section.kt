package com.example.graduationproject.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Section constructor(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @SerializedName("section")
    val section: String? = null,
    @SerializedName("display_name")
    val displayName: String? = null,
)
