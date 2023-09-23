package com.example.mobilewallpaper.ui.bottom_bar

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.mobilewallpaper.ui.Screen
import com.example.mobilewallpaper.util.Constant

@Composable
fun BottomBar(navController: NavController) {
    val listItems = listOf(
        BottomItem.CategoryScreen,
        BottomItem.FavoriteScreen,
        BottomItem.SettingsScreen,
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        Divider(color = MaterialTheme.colorScheme.primary)
        NavigationBar(
            containerColor = MaterialTheme.colorScheme.background,
            tonalElevation = 8.dp
        ) {
            listItems.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute?.substringBefore("/") == item.route.substringBefore("/"),
                    onClick = {
                        when (item.route.substringBefore("/")) {
                            currentRoute?.substringBefore("/") -> {}

                            Screen.CategoriesWallpaper.route -> {
                                navController.popBackStack(navController.graph.startDestinationId, false)
                            }

                            Screen.FavoriteScreen.route -> {
                                navController.navigate(item.route + "/${Constant.FAVORITE}") {
                                    popUpTo(item.route) {
                                        inclusive = true
                                    }
                                }
                            }

                            Screen.SettingsScreen.route -> {
                                navController.navigate(item.route) {
                                    popUpTo(item.route) {
                                        inclusive = true
                                    }
                                }
                            }

                        }
                    },
                    icon = {
                        Icon(painter = painterResource(id = item.icon), contentDescription = "")
                    }
                )
            }
        }
    }
}