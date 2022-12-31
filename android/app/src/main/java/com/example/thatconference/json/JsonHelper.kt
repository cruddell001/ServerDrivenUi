package com.example.thatconference.json

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val jsonSerializer = Json {
    ignoreUnknownKeys = true;
    encodeDefaults = false
}

inline fun <reified T>String.fromJson(): T? {
    if (this.isEmpty()) return null
    return try {
        jsonSerializer.decodeFromString<T>(this)
    } catch (e: Throwable) {
        e.printStackTrace()
        null
    }
}

inline fun <reified T>T.toJson(): String {
    return try {
        jsonSerializer.encodeToString(this)
    } catch (e: Throwable) {
        e.printStackTrace()
        ""
    }
}
