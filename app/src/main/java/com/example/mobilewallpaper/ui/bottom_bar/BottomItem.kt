package com.example.mobilewallpaper.ui.bottom_bar

import android.graphics.drawable.Icon
import com.example.mobilewallpaper.R
import com.example.mobilewallpaper.ui.Screen

sealed class BottomItem(val route: String, val icon: Int) {
    data object CategoryScreen: BottomItem(
        route = Screen.CategoriesWallpaper.route,
        icon = R.drawable.categories
    )
    data object FavoriteScreen: BottomItem(
        route = Screen.FavoriteScreen.route,
        icon = R.drawable.favorite_border

    )
    data object SettingsScreen: BottomItem(
        route = Screen.SettingsScreen.route,
        icon = R.drawable.settings
    )
}