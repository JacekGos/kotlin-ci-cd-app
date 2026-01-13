package com.jacekg.kotlin_test.controller

import com.jacekg.kotlin_test.dto.DetailsResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1")
class TestController {

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    @GetMapping("/details")
    fun getDetails(): DetailsResponse {
        return DetailsResponse(InetAddress.getLocalHost().hostName,
            LocalDateTime.now().format(formatter))
    }
}