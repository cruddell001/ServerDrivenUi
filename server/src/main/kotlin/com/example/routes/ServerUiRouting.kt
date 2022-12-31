package com.example.routes

import com.example.extensions.asServerUi
import com.example.extensions.asShowList
import com.example.extensions.sendResponse
import com.example.tmdb.TMDBHelper
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.serverUiRouting() {
    routing {
        get("/v2/tv/popular") {
            val shows = TMDBHelper.getPopularShows()?.asServerUi()
            call.sendResponse(shows ?: "Unable to retrieve shows")
        }
        get("/v2/movies/popular") {
            val shows = TMDBHelper.getPopularMovies()?.asServerUi()
            call.sendResponse(shows ?: "Unable to retrieve shows")
        }
    }
}
