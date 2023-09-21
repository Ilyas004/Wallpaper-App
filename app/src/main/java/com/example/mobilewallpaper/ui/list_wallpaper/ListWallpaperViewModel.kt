package com.example.mobilewallpaper.ui.list_wallpaper

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mobilewallpaper.data.repository.WallpaperDatabaseRepository
import com.example.mobilewallpaper.data.repository.WallpapersApiRepository
import com.example.mobilewallpaper.model.Wallpaper
import com.example.mobilewallpaper.util.Constant
import kotlinx.coroutines.launch


class ListWallpaperViewModel(
    private val apiRepository: WallpapersApiRepository,
    private val databaseRepository: WallpaperDatabaseRepository
) : ViewModel() {

    val listWallpaper : MutableState<List<Wallpaper>> = mutableStateOf(emptyList())

    fun loadWallpaper(category: String) {
        when(category) {
            Constant.FAVORITE -> { getWallpaperDB() }
            else -> { loadWallpaperApi(category) }
        }
    }

    private fun loadWallpaperApi(category: String) {
        viewModelScope.launch {
            val result = apiRepository.getWallpapersByName(category)
            listWallpaper.value = result
        }
    }

    private fun getWallpaperDB() {
        viewModelScope.launch {
            val result = databaseRepository.getWallpaper()
            listWallpaper.value = result
        }
    }
}