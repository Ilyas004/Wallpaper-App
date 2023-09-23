package com.example.mobilewallpaper.ui.list_wallpaper

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mobilewallpaper.ui.Screen
import com.example.mobilewallpaper.ui.bottom_bar.BottomBar
import com.example.mobilewallpaper.ui.detail_wallpaper.WALLPAPER
import com.example.mobilewallpaper.ui.theme.MobileWallpaperTheme
import com.example.mobilewallpaper.util.Constant
import com.example.mobilewallpaper.util.SettingState
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListWallpaperScreen(
    navController: NavController,
    category: String,
    viewModel: ListWallpaperViewModel = koinViewModel()
) {

    viewModel.loadWallpaper(category = category)
    val listUrl = viewModel.listWallpaper.value
    MobileWallpaperTheme(darkTheme = SettingState.settingState.theme) {
        Column(modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
        ) {
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                text = category,
                fontSize = 30.sp,
                modifier = Modifier.padding(10.dp)
            )
            Divider()
            Spacer(modifier = Modifier.height(5.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(10.dp),
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background)
                    .padding(bottom = 80.dp)
            ) {
                listUrl.forEach { wallpaper ->
                    item {
                        Card(
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable {
                                    WALLPAPER = wallpaper
                                    navController.navigate(Screen.DetailWallpaper.route)
                                }
                        ) {

                            AsyncImage(
                                model = wallpaper.url,
                                contentDescription = null,
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .fillMaxSize()
                                    .height(300.dp)
                            )
                        }
                    }
                }
            }
        }

        BottomBar(navController = navController)

        if (listUrl.isEmpty() && category != Constant.FAVORITE) {
            Box(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            }
        }
    }



}