package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class DbTable<T>(
    val items: List<T>
)
