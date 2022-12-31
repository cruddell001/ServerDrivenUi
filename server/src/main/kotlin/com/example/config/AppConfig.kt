package com.example.config

object AppConfig {

    fun getTmdbKey(): String = environmentVariable("tmdb_key") ?: ""

    private fun environmentVariable(key: String): String? = System.getenv()[key]
}
