package com.example.mobilewallpaper

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.core.view.WindowCompat
import com.example.mobilewallpaper.data.repository.SettingsRepository
import com.example.mobilewallpaper.ui.theme.MobileWallpaperTheme
import com.example.mobilewallpaper.util.Constant
import com.example.mobilewallpaper.util.SettingState
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class MainActivity : ComponentActivity(), KoinComponent {
    private val settingStorage: SettingsRepository by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val darkTheme by remember { mutableStateOf( SettingState.settingState.theme ) }


            MobileWallpaperTheme(darkTheme = darkTheme) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,

                ) {

                    val displayMetrics = DisplayMetrics()
                    windowManager.defaultDisplay.getMetrics(displayMetrics)
                    val width = displayMetrics.widthPixels
                    val height = displayMetrics.heightPixels
                    Constant.HEIGHT = height
                    Constant.WIDTH = width

                    Navigation()

                }
            }

            LaunchedEffect(key1 = Unit) {
                SettingState.settingState = settingStorage.getSetting()
            }
        }
    }

}
