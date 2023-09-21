package com.chandradeepdev.plugins

import ch.qos.logback.core.status.Status
import ch.qos.logback.core.util.StatusPrinter
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*
import jdk.jshell.Snippet
import org.koin.ktor.plugin.Koin


fun Application.configureStatusPage(){

    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText(text = "404: Page Not Found", status = status)
        }
    }


}