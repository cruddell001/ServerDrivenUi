package com.example.thatconference.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.thatconference.ui.screens.movies.MovieList
import com.example.thatconference.ui.screens.television.TvList

enum class Route(val path: String) {
    Movies("movies"),
    TvShows("tv"),
    Favorites("favorites"),
}

fun NavController.navigate(route: Route) {
    navigate(route.path)
}

@Composable
fun AppNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    Box(modifier) {
        NavHost(navController, Route.Movies.path) {
            composable(Route.Movies.path) {
                MovieList()
            }
            composable(Route.TvShows.path) {
                TvList()
            }
        }
    }
}

