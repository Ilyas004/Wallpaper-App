package com.example.mobilewallpaper.ui.detail_wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilewallpaper.data.repository.WallpaperDatabaseRepository
import com.example.mobilewallpaper.model.Wallpaper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailWallpaperViewModel(
    private val wallpaperDatabaseRepository: WallpaperDatabaseRepository,
    private val wallpaperManager: WallpaperManager,
) : ViewModel() {

    var listWallpaper : List<Wallpaper> by mutableStateOf(emptyList())
    var wallpaper : Wallpaper by mutableStateOf(WALLPAPER)

    fun checkFavorites(idString: String) : Boolean {
        for (item in listWallpaper) {
            if (item.idString == idString) {
                wallpaper = item
                return true
            }
        }
        return false
    }

    fun getFavoritesWallpaper() {
        viewModelScope.launch {
            listWallpaper = wallpaperDatabaseRepository.getWallpaper()
        }
    }

    fun saveWallpaper(): Boolean {
        viewModelScope.launch {
            wallpaperDatabaseRepository.setWallpaper(wallpaper = wallpaper)
        }

        return true
    }

    fun deleteWallpaper(): Boolean {
        viewModelScope.launch {
            wallpaperDatabaseRepository.deleteWallpaper(idString = wallpaper.idString)
        }
        return false
    }

    fun installingWallpaperLockDisplay(imageUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val bitmap = bitmapConverting(imageUrl)
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_LOCK)

        }
    }

    fun installingWallpaperSystemDisplay(imageUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val bitmap = bitmapConverting(imageUrl)
            wallpaperManager.setBitmap(bitmap, null, true, WallpaperManager.FLAG_SYSTEM)
        }
    }

    fun installingWallpaperAllDisplay(imageUrl: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val bitmap = bitmapConverting(imageUrl)
            wallpaperManager.setBitmap(bitmap, null, true)
        }
    }

    private suspend fun bitmapConverting(imageUrl: String) : Bitmap {
        val bitmap = BitmapConverter.bitmapConverting(imageUrl)
        return bitmap
    }
}