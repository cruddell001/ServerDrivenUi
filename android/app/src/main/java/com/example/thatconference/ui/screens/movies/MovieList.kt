package com.example.thatconference.ui.screens.movies

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.thatconference.models.Movie
import com.example.thatconference.repository.DataRepository

@Composable
fun MovieList() {
    var movies by remember { mutableStateOf<List<Movie>>(emptyList()) }
    var selected by remember { mutableStateOf<Long?>(null) }

    LaunchedEffect(key1 = Unit) {
        movies = DataRepository.popularMovies()
    }

    Box(Modifier.fillMaxSize().background(Color.LightGray)) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            movies.forEach {
                MovieView(it, selected = selected == it.id) {
                    selected =
                        if (selected == it.id) null
                        else it.id
                }
            }
        }
    }
}
