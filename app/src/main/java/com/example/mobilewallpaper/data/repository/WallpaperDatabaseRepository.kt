package com.example.mobilewallpaper.data.repository

import com.example.mobilewallpaper.data.room.WallpaperDao
import com.example.mobilewallpaper.model.Wallpaper

class WallpaperDatabaseRepository(private val dao: WallpaperDao) {

    suspend fun getWallpaper() : List<Wallpaper> {
        return dao.getWallpaper()
    }

    suspend fun setWallpaper(wallpaper: Wallpaper) {
        dao.setWallpaper(wallpaper)
    }

    suspend fun deleteWallpaper(wallpaper: Wallpaper) {
        dao.deleteWallpaper(wallpaper)
    }
}