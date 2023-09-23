package com.example.mobilewallpaper.data.api.dto

import com.example.mobilewallpaper.model.Wallpaper


data class Result(
    val blur_hash: String,
    val color: String,
    val created_at: String,
    val current_user_collections: List<Any>,
    val description: String,
    val height: Int,
    val id: String,
    val liked_by_user: Boolean,
    val likes: Int,
    val links: Links,
    val urls: Urls,
    val user: User,
    val width: Int
)

fun Result.toWallpaper(): Wallpaper {
    return Wallpaper(
        url = links.download,
        idString = id
    )
}
