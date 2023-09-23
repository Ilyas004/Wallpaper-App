package com.example.mobilewallpaper.ui.detail_wallpaper.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

const val DISPLAY_LOCK = "Экран блокировки"
const val DISPLAY_SYSTEM = "Рабочий стол"
const val ALL_DISPLAY = "Оба экрана"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WallpaperInstallMenu(
    onInstallToLockScreenClick: () -> Unit,
    onInstallToSystemClick: () -> Unit,
    onInstallToBothClick: () -> Unit,
    onDismiss: () -> Unit
) {


    ModalBottomSheet(
        modifier = Modifier.background(Color.Transparent),
        onDismissRequest = { onDismiss() }
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, bottom = 40.dp)
        ) {
            Text(text = DISPLAY_LOCK,
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    onInstallToLockScreenClick()
                    onDismiss()
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = DISPLAY_SYSTEM,
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    onInstallToSystemClick()
                    onDismiss()
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = ALL_DISPLAY,
                fontSize = 16.sp,
                modifier = Modifier.clickable {
                    onInstallToBothClick()
                    onDismiss()
                }
            )
        }
    }
}