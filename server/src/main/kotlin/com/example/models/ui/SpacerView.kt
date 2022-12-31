package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class SpacerView(
    val vertical: Boolean = true,
    val type: String = "SpacerView",
): ServerView()
