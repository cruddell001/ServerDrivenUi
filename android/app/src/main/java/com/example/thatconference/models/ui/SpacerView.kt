package com.example.thatconference.models.ui

import com.example.thatconference.models.ui.ServerView
import kotlinx.serialization.Serializable

@Serializable
data class SpacerView(
    val vertical: Boolean = true,
    val type: String = "SpacerView",
): ServerView()
