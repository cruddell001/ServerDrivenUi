package com.example.routes

import com.example.extensions.asMovieList
import com.example.extensions.asShowList
import com.example.extensions.bodyOrNull
import com.example.extensions.sendResponse
import com.example.models.Favorite
import com.example.repository.FavoritesRepository
import com.example.tmdb.TMDBHelper
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*

fun Application.configureRouting() {

    routing {
        get("/") {
            call.respondText("Hello World!")
        }

        get("/movies/recent") {
            val movies = TMDBHelper.getRecentMovies()?.asMovieList()
            call.sendResponse(movies ?: "Unable to retrieve movies")
        }

        get("/movies/topGrossing") {
            val movies = TMDBHelper.getTopGrossingMovies()?.asMovieList()
            call.sendResponse(movies ?: "Unable to retrieve movies")
        }

        get("/movies/popular") {
            val movies = TMDBHelper.getPopularMovies()?.asMovieList()
            call.sendResponse(movies ?: "Unable to retrieve movies")
        }

        get("/tv/recent") {
            val shows = TMDBHelper.getRecentShows()?.asShowList()
            call.sendResponse(shows ?: "Unable to retrieve shows")
        }

        get("/tv/popular") {
            val shows = TMDBHelper.getPopularShows()?.asShowList()
            call.sendResponse(shows ?: "Unable to retrieve shows")
        }

        post("/user/{userId}/favorites") {
            val userId = call.parameters["userId"] ?: ""
            val favorite: Favorite = call.bodyOrNull()
                ?: return@post call.sendResponse("You did not post a favorite")
            val newList = FavoritesRepository.addFavorite(userId, favorite)
            call.sendResponse(newList)
        }

        get("/user/{userId}/favorites") {
            val userId = call.parameters["userId"] ?: ""
            val favorites = FavoritesRepository.getFavorites(userId)
            call.sendResponse(favorites)
        }

        delete("/user/{userId}/favorites/{favoriteId}") {
            val userId = call.parameters["userId"] ?: ""
            val favoriteId = call.parameters["favoriteId"] ?: ""
            val deleted = FavoritesRepository.removeFavorite(userId, favoriteId)
            if (!deleted) call.sendResponse("Unable to remove favorite: $favoriteId")
            else call.sendResponse(FavoritesRepository.getFavorites(userId))
        }
    }
}
