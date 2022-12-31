package com.example.thatconference.repository

import android.util.Log
import com.example.thatconference.json.jsonSerializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString


object ApiHelper {
    private val baseUrl = "http://10.0.2.2:8080"

    @PublishedApi internal val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            jsonSerializer
        }
    }

    suspend inline fun <reified T>getRequest(path: String): T? =
        makeRequest(HttpMethod.GET, buildUrl(path))

    suspend inline fun <reified T>postRequest(path: String, body: Any? = null): T? =
        makeRequest(HttpMethod.POST, buildUrl(path), body)

    suspend inline fun <reified T>putRequest(path: String, body: Any? = null): T? =
        makeRequest(HttpMethod.PUT, buildUrl(path), body)

    suspend inline fun <reified T>deleteRequest(path: String): T? =
        makeRequest(HttpMethod.DELETE, buildUrl(path))

    @PublishedApi
    internal fun buildUrl(path: String): String = "$baseUrl$path"

    @PublishedApi
    internal suspend inline fun <reified T>makeRequest(method: HttpMethod, url: String, requestBody: Any? = null): T? {
        println("makeRequest($method): $url")
        return try {
            val resp = when (method) {
                HttpMethod.GET -> client.get(url)
                HttpMethod.POST -> client.post(url) {
                    setBody(requestBody)
                }
                HttpMethod.PUT -> client.put(url) {
                    setBody(requestBody)
                }
                HttpMethod.DELETE -> client.delete(url)
            }
            val body = resp.bodyAsText()
            Log.d("ApiHelper", body)
            jsonSerializer.decodeFromString(body)
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }
    }

    enum class HttpMethod {
        GET,
        POST,
        PUT,
        DELETE
    }
}
