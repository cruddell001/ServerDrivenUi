package com.example.thatconference.models

import kotlinx.serialization.Serializable

@Serializable
data class OkayResponse<T>(
    val body: T
)
