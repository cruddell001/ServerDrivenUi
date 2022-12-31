package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class CardView(
    val content: ServerView,
    val type: String = "CardView",
): ServerView()
