package com.example.thatconference.models

import kotlinx.serialization.Serializable

@Serializable
data class ErrorResponse(
    val error: String
)
