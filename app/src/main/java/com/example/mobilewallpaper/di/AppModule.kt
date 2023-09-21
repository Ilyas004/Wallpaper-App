package com.example.mobilewallpaper.di

import android.app.WallpaperManager
import androidx.room.Room
import com.example.mobilewallpaper.data.api.WallpaperApi
import com.example.mobilewallpaper.data.repository.WallpaperDatabaseRepository
import com.example.mobilewallpaper.data.repository.WallpapersApiRepository
import com.example.mobilewallpaper.data.room.WallpaperDatabase
import com.example.mobilewallpaper.ui.list_wallpaper.ListWallpaperViewModel
import com.example.mobilewallpaper.util.Constant
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val appModule = module {

    single<WallpaperApi> {
        Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WallpaperApi::class.java)
    }

    single<WallpapersApiRepository> {
        WallpapersApiRepository(api = get())
    }

    single<WallpaperDatabaseRepository> {
        WallpaperDatabaseRepository(dao = get())
    }

    viewModel<ListWallpaperViewModel> {
        ListWallpaperViewModel(apiRepository = get(), databaseRepository = get())
    }

    single<WallpaperManager> {
        WallpaperManager.getInstance(androidContext())
    }

    single {
        Room.databaseBuilder(
            androidContext(),
            WallpaperDatabase::class.java,
            "wallpaper_database"
        ).build()
    }

    single { get<WallpaperDatabase>().getWallpaperDao() }
}