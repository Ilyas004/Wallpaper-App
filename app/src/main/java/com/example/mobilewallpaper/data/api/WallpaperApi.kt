package com.example.mobilewallpaper.data.api

import com.example.mobilewallpaper.data.api.dto.WallpapersDto
import com.example.mobilewallpaper.util.Constant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET
import retrofit2.http.Query

interface WallpaperApi {

    @GET("/search/photos")
    suspend fun getWallpapersByName(
        @Query("client_id") key: String = Constant.KEY,
        @Query("query") name: String,
        @Query("per_page") count: Int = 20,
        @Query("lang") lang: String = "ru",
        @Query("w") width: Int = Constant.WIDTH,
        @Query("h") height: Int = Constant.HEIGHT,
    ) : WallpapersDto
}


