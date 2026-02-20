package com.jacekg.kotlin_test.controller

import com.jacekg.kotlin_test.dto.DetailsResponse
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.InetAddress
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@RequestMapping("/api/v1")
class TestController {

    private val logger = LoggerFactory.getLogger(TestController::class.java)
    val formatter: DateTimeFormatter? = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    @GetMapping("/details")
    fun getDetails(): DetailsResponse {
        logger.info("getting details ")
        return DetailsResponse(InetAddress.getLocalHost().hostName,
            "Hello",
            LocalDateTime.now().format(formatter))
    }

    @GetMapping("/health")
    fun health(): Map<String, String> {
        logger.info("checking health for ${InetAddress.getLocalHost().hostName}!")
        return mapOf("status" to "UP")
    }
}