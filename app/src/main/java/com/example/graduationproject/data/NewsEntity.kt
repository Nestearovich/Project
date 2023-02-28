package com.example.graduationproject.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "NewsEntity")
data class NewsEntity(
    @PrimaryKey(autoGenerate = false)
    val `abstract`: String,
    val byline: String,
    val created_date: String,
    val des_facet: Any,
    val first_published_date: String,
    val geo_facet: Any,
    val item_type: String,
    val kicker: String,
    val material_type_facet: String,
    val multimedia: Any,
    val org_facet: Any,
    val per_facet: Any,
    val published_date: String,
    val related_urls: Any,
    val section: String,
    val slug_name: String,
    val source: String,
    val subheadline: String,
    val subsection: String,
    val title: String,
    val updated_date: String,
    val uri: String,
    val url: String
)