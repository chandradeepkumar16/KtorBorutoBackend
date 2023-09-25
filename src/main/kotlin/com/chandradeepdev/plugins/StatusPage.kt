package com.chandradeepdev.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*


//configure pages for bad request and unknown end points
fun Application.configureStatusPage(){

    install(StatusPages) {
        status(HttpStatusCode.NotFound) { call, status ->
            call.respondText(text = "404: Page Not Found", status = HttpStatusCode.NotFound)
        }

        exception<Throwable> { call, cause ->
            call.respondText(text = "We have caught an Exception: $cause" , status = HttpStatusCode.OK)
        }
    }

}