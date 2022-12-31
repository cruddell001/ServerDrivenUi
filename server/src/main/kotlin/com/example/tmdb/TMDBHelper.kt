package com.example.tmdb

import com.example.models.tmdb.TmdbMovieList
import com.example.models.tmdb.TmdbShowList

object TMDBHelper {

    suspend fun getRecentMovies(): TmdbMovieList? {
        val path = "discover/movie?sort_by=release_date.desc&primary_release_year=2022"
        return TmdbApiHelper.getRequest(path)
    }

    suspend fun getTopGrossingMovies(): TmdbMovieList? {
        val path = "discover/movie?sort_by=revenue.desc"
        return TmdbApiHelper.getRequest(path)
    }

    suspend fun getPopularMovies(): TmdbMovieList? {
        val path = "discover/movie?sort_by=popularity.desc"
        return TmdbApiHelper.getRequest(path)
    }


    suspend fun getRecentShows(): TmdbShowList? {
        val path = "discover/tv?sort_by=first_air_date.desc"
        return TmdbApiHelper.getRequest(path)
    }

    suspend fun getPopularShows(): TmdbShowList? {
        val path = "discover/tv?sort_by=popularity.desc"
        return TmdbApiHelper.getRequest(path)
    }

}
