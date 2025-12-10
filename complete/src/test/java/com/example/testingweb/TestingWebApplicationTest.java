package com.example.testingweb;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureRestTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.client.RestTestClient;

@SpringBootTest
@AutoConfigureRestTestClient
class TestingWebApplicationTest {

	@Autowired
	private RestTestClient restTestClient;

	@Test
	void greetingShouldReturnDefaultMessage() {
		restTestClient.get().uri("/")
				.exchange()
				.expectBody(String.class)
				.isEqualTo("Hello, World");
	}
}
