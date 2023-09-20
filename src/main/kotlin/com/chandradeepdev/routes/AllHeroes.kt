package com.chandradeepdev.routes

import com.chandradeepdev.models.ApiResponse
import com.chandradeepdev.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun Route.getAllHeroes(){

    val heroRepository: HeroRepository by inject()

    get("/boruto/heroes") {
        try {
            //pagination has been added
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            require(page in 1..5)

            val apiResponse =heroRepository.getAllHeroes(page)

            call.respond(message = apiResponse,
                status = HttpStatusCode.OK)

        }catch (e :NumberFormatException){
            call.respond(
                message = ApiResponse(false, "Only numbers allowed"),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException){
            call.respond(
                message = ApiResponse(false, "Heroes not found"),
                status = HttpStatusCode.BadRequest
            )
        }
    }
}