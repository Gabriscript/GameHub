package com.ggargani.gamehub.service

import com.ggargani.gamehub.dto.GameDto
import com.ggargani.gamehub.model.GameEntity
import com.ggargani.gamehub.repository.GameRepository
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus

@Service
class GameService(
    private val gameRepository: GameRepository
) {

    private val fallbackGames = listOf(
        GameDto(1, title = "tic-tac-toe", description = "Classic X/O game", genre = "board", buildPath = "/games/tic-tac-toe"),
        GameDto(2, title = "luckyRun", description = "Run and collect coins", genre = "runner", buildPath = "/games/luckyRun"),
        GameDto(3, title = "DevTerms", description = "Developer terms and definitions", genre = "reference", buildPath = "/games/DevTerms")
    )

    fun getAllGames(): List<GameDto> {
        val fromDb = gameRepository.findAll().map { it.toDto() }
        return if (fromDb.isEmpty()) fallbackGames else fromDb
    }

    fun getGameById(id: Long): GameDto {
        gameRepository.findById(id).orElse(null)?.let { return it.toDto() }
        fallbackGames.firstOrNull { it.id == id }?.let { return it }
        throw ResponseStatusException(HttpStatus.NOT_FOUND, "Game not found")
    }

    fun createGame(dto: GameDto): GameDto {
        val entity = GameEntity(
            title = dto.title,
            description = dto.description,
            genre = dto.genre,
            buildPath = dto.buildPath
        )
        return gameRepository.save(entity).toDto()
    }
}

fun GameEntity.toDto() = GameDto(
    id = id,
    title = title,
    description = description,
    genre = genre,
    buildPath = buildPath
)


