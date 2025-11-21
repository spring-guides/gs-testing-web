package com.example.testingweb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class GreetingController(private val service: GreetingService) {

    @GetMapping("/greeting")
    fun greeting(): String = service.greet()
}
