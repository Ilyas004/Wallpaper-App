package com.example.mobilewallpaper

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mobilewallpaper.ui.Screen
import com.example.mobilewallpaper.ui.category_wallpaper.CategoriesWallpaperScreen
import com.example.mobilewallpaper.ui.detail_wallpaper.DetailWallpaperScreen
import com.example.mobilewallpaper.ui.list_wallpaper.ListWallpaperScreen
import com.example.mobilewallpaper.ui.setting.SettingsScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.CategoriesWallpaper.route
    ) {
        composable(Screen.CategoriesWallpaper.route) {
            CategoriesWallpaperScreen(navController)
        }

        composable(
            route = Screen.ListWallpaper.route + "/{category}",
            arguments = listOf(
                navArgument("category") {
                    type = NavType.StringType
                }
            )
        ) {
            val result = it.arguments?.getString("category") ?: ""
            ListWallpaperScreen(navController = navController, category = result)
        }

        composable(
            route = Screen.DetailWallpaper.route,
        ) {
            DetailWallpaperScreen(navController = navController)
        }

        composable(
            route = Screen.FavoriteScreen.route + "/{favorite}",
            arguments = listOf(
                navArgument("favorite") {
                    type = NavType.StringType
                }
            )
        ) {
            val result = it.arguments?.getString("favorite") ?: ""
            ListWallpaperScreen(navController = navController, category = result)
        }

        composable(
            route = Screen.SettingsScreen.route
        ) {
            SettingsScreen(navController = navController)
        }
    }
}