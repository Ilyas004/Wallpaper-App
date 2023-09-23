package com.example.mobilewallpaper.data.setting

import android.content.Context
import android.content.SharedPreferences
import com.example.mobilewallpaper.model.Setting

const val SHARED_PREFS_NAME = "shared_prefs_name"
const val KEY_THEME = "key_theme"

class SettingStorage(private val context: Context) {

    val sharedPref = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    fun saveSetting(setting: Setting) {
        sharedPref.edit().putBoolean(KEY_THEME, setting.theme).apply()
    }

    fun getSetting() : Setting {
        val theme = sharedPref.getBoolean(KEY_THEME, false)

        return Setting(theme = theme)
    }
}