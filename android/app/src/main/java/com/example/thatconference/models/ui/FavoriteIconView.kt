package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class FavoriteIconView(
    val iconSize: Int = 24,
    val color: String = "ff0000",
    val type: String = "FavoriteIconView",
): ServerView()
