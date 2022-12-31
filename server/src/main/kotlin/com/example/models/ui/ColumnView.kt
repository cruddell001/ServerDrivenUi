package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class ColumnView(
    val items: List<ServerView>,
    val itemPadding: Int = 0,
    val type: String = "ColumnView",
): ServerView()
