package com.example.models.tmdb

import kotlinx.serialization.Serializable

@Serializable
data class TmdbShowList(
    val page: Int,
    val total_pages: Int,
    val total_results: Int,
    val results: List<TmdbShow>,
)
