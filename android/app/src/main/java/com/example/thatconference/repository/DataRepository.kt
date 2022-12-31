package com.example.thatconference.repository

import com.example.thatconference.models.Movie
import com.example.thatconference.models.MovieList
import com.example.thatconference.models.TvShow
import com.example.thatconference.models.TvShowList

object DataRepository {

    suspend fun getRecentMovies(): List<Movie> {
        val movies: MovieList? = ApiHelper.getRequest("/movies/recent")
        return movies?.results ?: emptyList()
    }

    suspend fun popularMovies(): List<Movie> {
        val movies: MovieList? = ApiHelper.getRequest("/movies/popular")
        return movies?.results ?: emptyList()
    }

    suspend fun popularShows(): List<TvShow> {
        val shows: TvShowList? = ApiHelper.getRequest("/tv/popular")
        return shows?.results ?: emptyList()
    }
}
