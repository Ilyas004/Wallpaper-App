package com.example.mobilewallpaper.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wallpaper")
data class WallpaperDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val url: String,
    val idString: String = "",
)

fun WallpaperDB.toWallpaper(): Wallpaper {
    return Wallpaper(
        id = id,
        url = url,
        idString = idString,
    )
}
