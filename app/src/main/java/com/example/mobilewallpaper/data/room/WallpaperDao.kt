package com.example.mobilewallpaper.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobilewallpaper.model.Wallpaper


@Dao
interface WallpaperDao {

    @Query("SELECT * FROM wallpaper")
    suspend fun getWallpaper(): List<Wallpaper>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setWallpaper(wallpaper: Wallpaper)

    @Delete
    suspend fun deleteWallpaper(wallpaper: Wallpaper)
}