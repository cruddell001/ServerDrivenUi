package com.example.extensions

import com.example.models.ErrorResponse
import io.ktor.server.application.*
import io.ktor.server.plugins.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.util.reflect.*

suspend inline fun <reified T: Any>ApplicationCall.sendResponse(body: T) {
    if (body is String) {
        respond(ErrorResponse(error = body))
    } else {
        respond(body)
    }
}

public suspend inline fun <reified T : Any> ApplicationCall.bodyOrNull(): T? =
    try { this.receive() } catch (e: Throwable) {
        e.printStackTrace()
        null
    }
