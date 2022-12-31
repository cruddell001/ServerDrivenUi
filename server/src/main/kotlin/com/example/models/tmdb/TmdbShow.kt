package com.example.models.tmdb

import kotlinx.serialization.Serializable

@Serializable
data class TmdbShow(
    val backdrop_path: String?,
    val first_air_date: String,
    val genre_ids: List<Int>,
    val id: Long,
    val name: String,
    val origin_country: List<String>,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Float,
    val poster_path: String?,
    val vote_average: Float,
    val vote_count: Int
)
