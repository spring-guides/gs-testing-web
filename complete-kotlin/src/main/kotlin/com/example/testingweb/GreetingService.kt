package com.example.testingweb

import org.springframework.stereotype.Service

@Service
class GreetingService {
    fun greet(): String = "Hello, World"
}
