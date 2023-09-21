package com.example.mobilewallpaper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpaper")
data class Wallpaper(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val url: String,
)