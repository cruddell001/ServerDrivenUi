package com.example.models.tmdb

import kotlinx.serialization.Serializable

@Serializable
data class TmdbMovieList(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<TmdbMovie>,
)


