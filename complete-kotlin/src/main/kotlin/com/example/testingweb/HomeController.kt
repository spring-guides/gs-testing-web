package com.example.testingweb

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HomeController {

    @GetMapping("/")
    fun greeting(): String = "Hello, World"
}
