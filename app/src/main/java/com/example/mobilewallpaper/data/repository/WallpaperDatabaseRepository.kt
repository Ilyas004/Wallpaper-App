package com.example.mobilewallpaper.data.repository

import com.example.mobilewallpaper.data.room.WallpaperDao
import com.example.mobilewallpaper.model.Wallpaper
import com.example.mobilewallpaper.model.toWallpaper
import com.example.mobilewallpaper.model.toWallpaperDB

class WallpaperDatabaseRepository(private val dao: WallpaperDao) {

    suspend fun getWallpaper() : List<Wallpaper> {
        return dao.getWallpaper().map { it.toWallpaper() }
    }

    suspend fun setWallpaper(wallpaper: Wallpaper) {
        dao.setWallpaper(wallpaper.toWallpaperDB())
    }

    suspend fun deleteWallpaper(idString: String) {
        dao.deleteWallpaper(idString)
    }
}