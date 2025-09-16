package com.example.testingweb

import org.hamcrest.Matchers.containsString
import org.junit.jupiter.api.Test
import org.mockito.Mockito.`when`
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.context.bean.override.mockito.MockitoBean
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(GreetingController::class)
class WebMockTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @MockitoBean
    private lateinit var service: GreetingService

    @Test
    fun greetingShouldReturnMessageFromService() {
        `when`(service.greet()).thenReturn("Hello, Mock")
        mockMvc.perform(get("/greeting"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Hello, Mock")))
    }
}
