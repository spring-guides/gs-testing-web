package com.example.testingweb

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.client.RestTestClient
import org.springframework.test.web.servlet.client.expectBody

@SpringBootTest
@AutoConfigureRestTestClient
class TestingWebApplicationTest(@Autowired private val restTestClient: RestTestClient) {

    @Test
    fun greetingShouldReturnDefaultMessage() {
        // Import Kotlin .expectBody() extension that allows using reified type parameters
        restTestClient.get().uri("/")
            .exchange()
            .expectBody<String>()
            .isEqualTo("Hello, World")
    }

}