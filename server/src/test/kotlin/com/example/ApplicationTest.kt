package com.example

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.http.cio.websocket.*
import io.ktor.server.websocket.*
import java.time.*
import io.ktor.server.plugins.*
import org.slf4j.event.*
import io.ktor.serializaion.gson.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*
import kotlin.test.*
import io.ktor.server.testing.*
import com.example.plugins.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication({ configureRouting() }) {
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals("Hello World!", response.content)
            }
        }
    }
}