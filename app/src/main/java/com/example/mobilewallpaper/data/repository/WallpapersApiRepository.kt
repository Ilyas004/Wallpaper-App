package com.example.mobilewallpaper.data.repository

import com.example.mobilewallpaper.data.api.WallpaperApi
import com.example.mobilewallpaper.data.api.dto.toWallpaper
import com.example.mobilewallpaper.model.Wallpaper

class WallpapersApiRepository(
    private val api: WallpaperApi
) {


    suspend fun getWallpapersByName(name: String): List<Wallpaper> {
        val listWallpaper = api.getWallpapersByName(name = name)
        return listWallpaper.results.map { it.toWallpaper(it) }
    }
}