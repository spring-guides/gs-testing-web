package com.example.testingweb

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment
import org.springframework.boot.test.web.server.LocalServerPort
import org.springframework.test.web.servlet.client.RestTestClient
import org.springframework.test.web.servlet.client.expectBody

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureRestTestClient
class HttpRequestTest {

    @LocalServerPort
    private var port: Int = 0

    @Autowired
    private lateinit var restTestClient: RestTestClient

    @Test
    fun greetingShouldReturnDefaultMessage() {
        // Import Kotlin .expectBody() extension that allows using reified type parameters
        restTestClient.get()
            .uri("http://localhost:$port/")
            .exchange()
            .expectBody<String>()
            .isEqualTo("Hello, World")
    }

}
