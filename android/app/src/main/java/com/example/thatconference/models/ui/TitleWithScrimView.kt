package com.example.thatconference.models.ui

import com.example.thatconference.models.ui.ServerView
import kotlinx.serialization.Serializable

@Serializable
data class TitleWithScrimView(
    val text: String,
    val fontSize: Int = 20,
    val wrapText: Boolean = true,
    val type: String = "TitleWithScrimView",
): ServerView()
