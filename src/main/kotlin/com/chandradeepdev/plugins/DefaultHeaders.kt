package com.chandradeepdev.plugins

import io.ktor.http.*
import io.ktor.server.application.*
import java.time.Duration

fun Application.configureDefaultHeader(){
    val oneYearInSeconds = Duration.ofDays(365).seconds
    headersOf(
        name = HttpHeaders.CacheControl ,
        value = "public , max-age=$oneYearInSeconds , immutable" )
}