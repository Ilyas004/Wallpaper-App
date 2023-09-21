package com.example.mobilewallpaper.data.api.dto

data class WallpapersDto(
    val results: List<Result>,
    val total: Int,
    val total_pages: Int
)
