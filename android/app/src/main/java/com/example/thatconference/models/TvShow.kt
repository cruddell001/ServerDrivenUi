package com.example.thatconference.models

import kotlinx.serialization.Serializable

@Serializable
data class TvShow(
    val id: Long,
    val backdropImage: String,
    val firstAirDate: String,
    val genres: List<Int>,
    val name: String,
    val description: String,
    val popularity: Float,
    val averageVote: Float,
    val voteCount: Int,
    val posterImage: String
)

@Serializable
data class TvShowList(
    val page: Int,
    val pages: Int,
    val totalCount: Int,
    val pageCount: Int,
    val results: List<TvShow>,
)