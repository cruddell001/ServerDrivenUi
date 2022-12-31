package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class FullWidthImageView(
    val imageUrl: String,
    val height: Int = 150,
    val contentDescription: String = "",
    val type: String = "FullWidthImageView",
): ServerView()
