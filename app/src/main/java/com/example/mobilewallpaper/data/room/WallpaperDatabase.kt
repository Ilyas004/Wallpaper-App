package com.example.mobilewallpaper.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.mobilewallpaper.model.WallpaperDB

@Database(entities = [WallpaperDB::class], version = 1, exportSchema = true)
abstract class WallpaperDatabase : RoomDatabase() {
    abstract fun getWallpaperDao() : WallpaperDao
}