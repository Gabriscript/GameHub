package com.ggargani.gamehub.controller

import com.ggargani.gamehub.dto.GameDto
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.PathVariable



import com.ggargani.gamehub.service.GameService

@RestController
@RequestMapping("/games")
class GameController(
    private val gameService: GameService
) {

    @GetMapping
    fun getGames(): List<GameDto> =
        gameService.getAllGames()

    @GetMapping("/{id}")
    fun getGameById(@PathVariable id: Long): GameDto =
        gameService.getGameById(id)
}

