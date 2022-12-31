package com.example.tmdb

import com.example.config.AppConfig
import com.example.serialization.jsonSerializer
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.decodeFromString

object TmdbApiHelper {
    @PublishedApi internal val baseUrl = "https://api.themoviedb.org/3/"
    @PublishedApi internal val apiKey get() = AppConfig.getTmdbKey()

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
    internal fun buildUrl(path: String): String = when {
        path.contains("?") -> "$baseUrl$path&api_key=$apiKey"
        else -> "$baseUrl$path?api_key=$apiKey"
    }

    @PublishedApi
    internal suspend inline fun <reified T>makeRequest(method: HttpMethod, url: String, requestBody: Any? = null): T? {
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
        return try {
            val body = resp.bodyAsText()
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