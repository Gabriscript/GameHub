package com.ggargani.gamehub.dto


data class GameDto(
    val id: Long? = null,
    val title: String,
    val description: String,
    val genre: String,
    val buildPath: String
)

