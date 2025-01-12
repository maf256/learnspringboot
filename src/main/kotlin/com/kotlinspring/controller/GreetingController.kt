package com.kotlinspring.controller

import com.kotlinspring.service.GreetingsService
import io.github.oshai.kotlinlogging.KLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/greetings")
class GreetingController(val greetingsService: GreetingsService) {

    companion object : KLogging()


    @GetMapping("/{name}")
    fun returnGreeting(@PathVariable("name") name: String): String {
        logger.info { "Name is $name!" }
        return greetingsService.returnGreeting(name)
    }
}
