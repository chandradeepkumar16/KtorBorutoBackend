package com.chandradeepdev

import com.chandradeepdev.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.*

@Suppress("UNUSED_EXPRESSION")
class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
           Application::module
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}
