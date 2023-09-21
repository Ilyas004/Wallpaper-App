package com.example.mobilewallpaper.ui.category_wallpaper

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilewallpaper.ui.Screen
import com.example.mobilewallpaper.ui.bottom_bar.BottomBar

@Composable
fun CategoriesWallpaperScreen(
    navController: NavController
) {
    Box(modifier = Modifier.fillMaxSize()) {
        LazyColumn {
            item {
                Text(
                    text = "Выберите категорию",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(start = 10.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Divider()
            }
            listСategories.forEach { category ->
                item {
                    Card(modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth()
                        .clickable {
                            navController.navigate(Screen.ListWallpaper.route + "/$category")
                        }
                    ) {
                        Text(
                            text = category,
                            fontSize = 16.sp,
                            modifier = Modifier
                                .padding(top = 10.dp, bottom = 10.dp, start = 10.dp)

                        )
                    }

                }
            }


        }
        BottomBar(navController = navController)
    }
}


@Composable
fun TestCollect() {
    CategoriesWallpaperScreen(navController = rememberNavController())
}