@file:Suppress("DEPRECATION")

package com.chandradeepdev.plugins

import com.chandradeepdev.routes.getAllHeroes
import com.chandradeepdev.routes.root
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        root()
        getAllHeroes()

        static("/images") {
            resources("images")
        }
    }
}
