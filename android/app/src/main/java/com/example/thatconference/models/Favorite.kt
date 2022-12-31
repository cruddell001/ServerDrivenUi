package com.example.thatconference.models

import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
    val userId: String? = null,
    val id: String? = null,
    val movie: Movie? = null,
    val show: TvShow? = null,
)
