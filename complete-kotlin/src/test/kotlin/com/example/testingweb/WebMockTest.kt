package com.example.testingweb

import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.client.RestTestClient
import org.springframework.test.web.servlet.client.expectBody

@WebMvcTest(GreetingController::class)
@AutoConfigureRestTestClient
class WebMockTest {

    @Autowired
    private lateinit var restTestClient: RestTestClient

    @MockitoBean
    private lateinit var service: GreetingService

    @Test
    fun greetingShouldReturnMessageFromService() {
        `when`(service.greet()).thenReturn("Hello, Mock")
        // Import Kotlin .expectBody() extension that allows using reified type parameters
        restTestClient.get()
            .uri("/greeting")
            .exchange()
            .expectBody<String>()
            .isEqualTo("Hello, Mock")
    }
}
