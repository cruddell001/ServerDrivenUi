package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class TextView(
    val text: String,
    val fontSize: Int,
    val color: String,
    val bold: Boolean,
    val italic: Boolean,
    val wrapText: Boolean = true,
    val padding: Int = 0,
    val type: String = "TextView",
): ServerView()
