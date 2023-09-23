package com.example.mobilewallpaper.data.repository

import com.example.mobilewallpaper.data.setting.SettingStorage
import com.example.mobilewallpaper.model.Setting

class SettingsRepository(private val settingStorage: SettingStorage) {

    fun saveSetting(setting: Setting) {
        settingStorage.saveSetting(setting)
    }

    fun getSetting(): Setting {
        return settingStorage.getSetting()
    }
}