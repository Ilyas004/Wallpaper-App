package com.example.mobilewallpaper.ui.detail_wallpaper

import android.app.WallpaperManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.ImageLoader
import coil.compose.AsyncImage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.androidx.compose.get
import java.net.URL

@Composable
fun DetailWallpaperScreen(
    navController: NavController,
    wallpaperManager: WallpaperManager = get()
) {
    val scope = rememberCoroutineScope()
    val imageUrl = WALLPAPER_URL


    Box(modifier = Modifier.fillMaxSize()) {
        AsyncImage(model = imageUrl,
            contentDescription = "wallpaper",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize(),

        )
        Button(
            onClick = {
                scope.launch(Dispatchers.IO) {
                    val bitmap = BitmapConverter.bitmapConverter(imageUrl)
                    wallpaperManager.setBitmap(bitmap)
                }
            },
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp)
                .background(Color.Transparent)
        ) {
            Text(text = "Установить", fontSize = 16.sp)
        }
    }
}
