package com.example.mobilewallpaper.data.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.mobilewallpaper.model.WallpaperDB


@Dao
interface WallpaperDao {

    @Query("SELECT * FROM wallpaper")
    suspend fun getWallpaper(): List<WallpaperDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setWallpaper(wallpaper: WallpaperDB)

    @Query("DELETE FROM wallpaper WHERE idString = :idString")
    suspend fun deleteWallpaper(idString: String)
}