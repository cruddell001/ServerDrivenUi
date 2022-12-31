package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class ColumnView(
    val items: List<ServerView>,
    val itemPadding: Int = 0,
    val scrollable: Boolean = true,
    val type: String = "ColumnView",
): ServerView()
