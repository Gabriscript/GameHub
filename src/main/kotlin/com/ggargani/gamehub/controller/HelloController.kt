package com.ggargani.gamehub.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import com.ggargani.gamehub.dto.HelloResponseDto

@RestController
class HelloController {


    @GetMapping("/hello")
    fun hello(): HelloResponseDto {
        return HelloResponseDto("Hello GameHub")
    }
}