package com.example.mobilewallpaper.ui.bottom_bar

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Icon
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

@Composable
fun BottomBar(navController: NavController) {
    val listItems = listOf(
        BottomItem.CategoryScreen,
        BottomItem.FavoriteScreen
    )

    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = backStackEntry?.destination?.route

    Column(
        modifier = Modifier
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom
    ) {
        NavigationBar(
            containerColor = White,
            modifier = Modifier
                .border(0.5.dp, color = Color.Black),
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
                                navController.navigate(item.route + "/favorite") {
                                    popUpTo(item.route) {
                                        inclusive = true
                                    }
                                }
                            }
                            else -> {}

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