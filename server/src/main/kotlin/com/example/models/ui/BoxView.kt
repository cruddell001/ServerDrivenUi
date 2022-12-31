package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class BoxView(
    val items: List<ServerView>,
    val constrainHeight: Boolean = true,
    val fullWidth: Boolean = true,
    val bgColor: String? = null,
    val padding: Int = 0,
    val type: String = "BoxView"
): ServerView()
