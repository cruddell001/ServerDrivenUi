package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Favorite(
    val userId: String? = null,
    val id: String? = null,
    val movie: Movie? = null,
    val show: TvShow? = null,
)
