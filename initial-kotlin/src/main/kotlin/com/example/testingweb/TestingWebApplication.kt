package com.example.testingweb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestingWebApplication

fun main(args: Array<String>) {
    runApplication<TestingWebApplication>(*args)
}
