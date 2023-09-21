package com.example.mobilewallpaper.ui

sealed class Screen(val route: String) {
    data object CategoriesWallpaper : Screen("categories_wallpaper_screen")
    data object ListWallpaper : Screen("list_wallpaper")
    data object DetailWallpaper : Screen("detail_wallpaper")
    data object FavoriteScreen : Screen("favorite_screen")
}
