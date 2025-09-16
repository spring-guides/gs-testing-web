package com.example.testingweb

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody

@Controller
class GreetingController(private val service: GreetingService) {

    @RequestMapping("/greeting")
    @ResponseBody
    fun greeting(): String = service.greet()
}
