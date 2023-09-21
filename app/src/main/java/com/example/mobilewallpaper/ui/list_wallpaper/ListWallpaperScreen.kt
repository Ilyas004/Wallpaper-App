package com.example.mobilewallpaper.ui.list_wallpaper

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
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
import com.example.mobilewallpaper.ui.detail_wallpaper.WALLPAPER_URL
import org.koin.androidx.compose.koinViewModel

@Composable
fun ListWallpaperScreen(
    navController: NavController,
    category: String,
    viewModel: ListWallpaperViewModel = koinViewModel()
) {

    viewModel.loadWallpaper(category = category)
    val listUrl = viewModel.listWallpaper.value

    Column {
        Text(
            text = category,
            fontSize = 30.sp,
            modifier = Modifier.padding(10.dp)
        )
        Divider()
        Spacer(modifier = Modifier.height(20.dp))
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            listUrl.forEach { url ->
                item {
                    Card(
                        shape = RoundedCornerShape(8.dp),
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                WALLPAPER_URL = url.url
                                navController.navigate(Screen.DetailWallpaper.route)
                            }
                    ) {

                        AsyncImage(
                            model = url.url,
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize().height(300.dp)
                        )
                    }
                }
            }
        }
    }

    if (listUrl.isEmpty()) {
        Box(modifier = Modifier.fillMaxSize()) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }


}