package com.example.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class ListView(
    val items: List<ServerView>,
    val type: String = "ListView",
): ServerView()
