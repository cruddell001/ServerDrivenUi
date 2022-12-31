package com.example.thatconference.ui.screens.television

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.thatconference.models.Movie
import com.example.thatconference.models.TvShow
import com.example.thatconference.repository.DataRepository
import com.example.thatconference.ui.screens.movies.MovieView

@Composable
fun TvList() {
    var movies by remember { mutableStateOf<List<TvShow>>(emptyList()) }
    var selected by remember { mutableStateOf<Long?>(null) }

    LaunchedEffect(key1 = Unit) {
        movies = DataRepository.popularShows()
    }

    Box(Modifier.fillMaxSize().background(Color.LightGray)) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            movies.forEach {
                TvView(it, selected = selected == it.id) {
                    selected =
                        if (selected == it.id) null
                        else it.id
                }
            }
        }
    }
}
