package com.example.repository

import com.example.models.DbTable
import com.example.models.Favorite
import com.example.serialization.fromJson
import com.example.serialization.toJson
import java.util.*

object FavoritesRepository {

    fun getFavorites(userId: String): List<Favorite> {
        val db = SimpleDatabase.getDb("favorites") ?: ""
        val allFavorites: DbTable<Favorite>? = db.fromJson()
        return allFavorites?.items?.filter { it.userId == userId } ?: emptyList()
    }

    fun addFavorite(userId: String, favorite: Favorite): List<Favorite> {
        val favorites = getFavorites(userId) + listOf(
            favorite.copy(
                id = UUID.randomUUID().toString(),
                userId = userId
            )
        )
        SimpleDatabase.saveDb("favorites", DbTable(favorites).toJson())
        return getFavorites(userId)
    }

    fun removeFavorite(userId: String, favoriteId: String): Boolean {
        val userFavorites = getFavorites(userId)
        if (userFavorites.none { it.id == favoriteId }) {
            println("unable to find favorite with matching id")
            return false
        }
        val favorites = userFavorites.filterNot { it.id == favoriteId }
        if (userFavorites.size == favorites.size) {
            println("found favorite but failed to delete")
            return false
        }
        SimpleDatabase.saveDb("favorites", DbTable(favorites).toJson())
        return true
    }

}
