package com.example.mobilewallpaper.ui.detail_wallpaper

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL

class BitmapConverter {
    companion object {
        suspend fun bitmapConverter(imageUrl: String) : Bitmap {
            val url = URL(imageUrl)
            val image = BitmapFactory.decodeStream(url.openConnection().getInputStream())
            return image
        }
    }
}

