package com.example.thatconference.models.ui

import kotlinx.serialization.Serializable

@Serializable
data class ListView(
    val items: List<ServerView>,
    val type: String = "ListView",
): ServerView()
