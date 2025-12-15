package com.ggargani.gamehub

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class GamehubApplication

fun main(args: Array<String>) {
	runApplication<GamehubApplication>(*args)
}
