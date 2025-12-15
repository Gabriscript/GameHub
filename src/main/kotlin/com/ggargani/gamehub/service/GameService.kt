package com.ggargani.gamehub.service

import com.ggargani.gamehub.dto.GameDto
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@Service
class GameService {

    private val games = listOf(
        GameDto(1, "Space Invaders", "Classic arcade shooter", "Arcade"),
        GameDto(2, "Tic Tac Toe", "Simple strategy game", "Puzzle")
    )

    fun getAllGames(): List<GameDto> {
        return games
    }

    fun getGameById(id: Long): GameDto {
        return games.find { it.id == id }
            ?: throw ResponseStatusException(
                HttpStatus.NOT_FOUND,
                "Game with id $id not found"
            )
    }
}


