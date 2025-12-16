package com.ggargani.gamehub.service

import com.ggargani.gamehub.dto.GameDto
import com.ggargani.gamehub.repository.GameRepository
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import org.springframework.http.HttpStatus
@Service
class GameService(
    private val gameRepository: GameRepository
) {

    fun getAllGames(): List<GameDto> =
        gameRepository.findAll().map {
            GameDto(
                id = it.id,
                title = it.title,
                description = it.description,
                genre = it.genre
            )
        }

    fun getGameById(id: Long): GameDto =
        gameRepository.findById(id)
            .map {
                GameDto(it.id, it.title, it.description, it.genre)
            }
            .orElseThrow {
                ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Game with id $id not found"
                )
            }
}



