package com.example.mobilewallpaper.ui.detail_wallpaper

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.mobilewallpaper.R
import com.example.mobilewallpaper.ui.detail_wallpaper.component.WallpaperInstallMenu
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailWallpaperScreen(
    navController: NavController,
    viewModel: DetailWallpaperViewModel = koinViewModel()
) {
    viewModel.getFavoritesWallpaper()

    val isFavorites = remember { mutableStateOf(true) }
    val isSheetOpen = remember { mutableStateOf(false) }

    isFavorites.value = viewModel.checkFavorites(idString = viewModel.wallpaper.idString)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        AsyncImage(model = viewModel.wallpaper.url,
            contentDescription = "wallpaper",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),

        )
        Row(
            modifier = Modifier.align(Alignment.BottomCenter),
            horizontalArrangement = Arrangement.spacedBy(30.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(
                onClick = {
                          isSheetOpen.value = true
                    //viewModel.installingWallpaper(imageUrl = viewModel.wallpaper.url)
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier
                    .padding(bottom = 20.dp)
                    .background(Color.Transparent)
            ) {
                Text(text = "Установить", fontSize = 16.sp)
            }
            Image(
                painter = painterResource(
                    if (isFavorites.value) {
                        R.drawable.favorite
                    } else {
                        R.drawable.favorite_border
                    }
                ),
                contentDescription = "Добавить в избранное",
                modifier = Modifier
                    .size(60.dp)
                    .padding(bottom = 20.dp)
                    .clickable {
                        isFavorites.value = if (isFavorites.value) {
                            viewModel.deleteWallpaper()
                        } else {
                            viewModel.saveWallpaper()

                        }
                    }
            )
        }
        if (isSheetOpen.value) {
            WallpaperInstallMenu(
                onInstallToLockScreenClick = { viewModel.installingWallpaperLockDisplay(viewModel.wallpaper.url) },
                onInstallToSystemClick = { viewModel.installingWallpaperSystemDisplay(viewModel.wallpaper.url) },
                onInstallToBothClick = { viewModel.installingWallpaperAllDisplay(imageUrl = viewModel.wallpaper.url) },
                onDismiss = { isSheetOpen.value = false }
            )
        }
    }
}
