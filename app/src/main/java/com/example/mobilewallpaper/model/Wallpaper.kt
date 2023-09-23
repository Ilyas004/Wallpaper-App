package com.example.mobilewallpaper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

data class Wallpaper(
    val id: Int = 0,
    val url: String,
    val idString: String = ""
)

fun Wallpaper.toWallpaperDB() : WallpaperDB {
    return WallpaperDB(
        url = url,
        idString = idString
    )
}