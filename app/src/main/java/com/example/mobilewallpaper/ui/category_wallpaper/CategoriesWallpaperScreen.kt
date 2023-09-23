package com.example.mobilewallpaper.ui.category_wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.mobilewallpaper.ui.Screen
import com.example.mobilewallpaper.ui.bottom_bar.BottomBar
import com.example.mobilewallpaper.ui.theme.MobileWallpaperTheme
import com.example.mobilewallpaper.util.SettingState

@Composable
fun CategoriesWallpaperScreen(
    navController: NavController
) {
    MobileWallpaperTheme(darkTheme = SettingState.settingState.theme) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            LazyColumn(modifier = Modifier.padding(bottom = 40.dp)) {


                item {
                    Text(
                        color = MaterialTheme.colorScheme.onSurface,
                        text = "Выберите категорию",
                        fontSize = 30.sp,
                        modifier = Modifier.padding(start = 10.dp, top = 10.dp),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                }


                listСategories.forEach { category ->
                    item {
                        Card(modifier = Modifier
                            .background(MaterialTheme.colorScheme.surface)
                            .padding(top = 10.dp)
                            .fillMaxWidth()
                            .clickable {
                                navController.navigate(Screen.ListWallpaper.route + "/$category")
                            }
                        ) {
                            Text(
                                text = category,
                                color = MaterialTheme.colorScheme.onSurface,
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

}