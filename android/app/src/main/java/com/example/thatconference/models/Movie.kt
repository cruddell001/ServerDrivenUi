package com.example.thatconference.models

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Long,
    val title: String,
    val voteCount: Int,
    val averageVote: Float,
    val description: String,
    val posterImage: String,
    val backdropImage: String,
    val releaseDate: String? = null,
    val genres: List<Int>
)

@Serializable
data class MovieList(
    val page: Int,
    val pages: Int,
    val totalCount: Int,
    val pageCount: Int,
    val results: List<Movie>,
)
