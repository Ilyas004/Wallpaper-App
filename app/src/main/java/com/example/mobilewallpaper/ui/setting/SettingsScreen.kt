package com.example.mobilewallpaper.ui.setting

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mobilewallpaper.data.repository.SettingsRepository
import com.example.mobilewallpaper.model.Setting
import com.example.mobilewallpaper.ui.bottom_bar.BottomBar
import com.example.mobilewallpaper.ui.theme.MobileWallpaperTheme
import com.example.mobilewallpaper.util.SettingState
import org.koin.compose.koinInject

const val SETTINGS = "Настройки"
const val THEME = "Светлая / Темная тема"

@Composable
fun SettingsScreen(
    navController: NavController,
    settingsRepository: SettingsRepository = koinInject()
) {
    val checkedTheme = remember { mutableStateOf(SettingState.settingState.theme) }
    MobileWallpaperTheme(darkTheme = checkedTheme.value) {
        Column(modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)) {
            Text(
                color = MaterialTheme.colorScheme.onSurface,
                text = SETTINGS,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 10.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    color = MaterialTheme.colorScheme.onSurface,
                    text = THEME,
                    fontSize = 20.sp
                )
                Switch(
                    checked = checkedTheme.value,
                    onCheckedChange = {
                        checkedTheme.value = it
                        SettingState.settingState.theme = it
                        settingsRepository.saveSetting(Setting(it))
                    }
                )
            }

            BottomBar(navController = navController)
        }
    }


}