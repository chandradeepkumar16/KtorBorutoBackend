package com.chandradeepdev.routes

import com.chandradeepdev.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.searchHeroes(){
    val heroRespository : HeroRepository by inject()


    get("/boruto/heroes/search") {
        val name = call.request.queryParameters["name"]

        val apiResponse= heroRespository.searchHeroes(name=name)
        call.respond(
            message = apiResponse,
            status = HttpStatusCode.OK
        )
    }
}