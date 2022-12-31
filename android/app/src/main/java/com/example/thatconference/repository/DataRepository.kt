package com.example.thatconference.repository

import com.example.thatconference.extensions.setParent
import com.example.thatconference.models.Movie
import com.example.thatconference.models.MovieList
import com.example.thatconference.models.TvShow
import com.example.thatconference.models.TvShowList
import com.example.thatconference.models.ui.GenericServerView
import com.example.thatconference.models.ui.ServerView

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

    suspend fun tvShowsAsUi(): ServerView {
        val serverView: ServerView = ApiHelper.getRequest("/v2/tv/popular") ?: GenericServerView()
        serverView.setParent()
        return serverView
    }

    suspend fun moviesAsUi(): ServerView {
        val view: ServerView = ApiHelper.getRequest("/v2/movies/popular") ?: GenericServerView()
        view.setParent()
        return view
    }
}
