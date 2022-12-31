package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class AnimatedVisibility(
    val content: ServerView,
    val type: String = "AnimatedVisibility"
): ServerView()
