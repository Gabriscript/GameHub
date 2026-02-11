package com.ggargani.gamehub.dto

import jakarta.validation.constraints.NotBlank

data class CreateGameRequsest(
    @field:NotBlank(message = "Title must not be blank")
    val title: String,
    @field:NotBlank(message = "Description must not be blank")
    val description: String,
    @field:NotBlank(message = "Genre must not be blank")
    val genre: String
)
