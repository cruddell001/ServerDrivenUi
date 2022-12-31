package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class TextView(
    val text: String,
    val fontSize: Int = 16,
    val color: String = "#000000",
    val bold: Boolean = false,
    val italic: Boolean = false,
    val wrapText: Boolean = true,
    val padding: Int = 0,
    val type: String = "TextView",
): ServerView()
