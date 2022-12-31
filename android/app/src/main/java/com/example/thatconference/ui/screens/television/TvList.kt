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
import com.example.thatconference.models.TvShow
import com.example.thatconference.repository.DataRepository

@Composable
fun TvList() {
    var shows by remember { mutableStateOf<List<TvShow>>(emptyList()) }
    var selected by remember { mutableStateOf<Long?>(null) }

    LaunchedEffect(key1 = Unit) {
        shows = DataRepository.popularShows()
    }

    Box(Modifier.fillMaxSize().background(Color.LightGray)) {
        Column(Modifier.verticalScroll(rememberScrollState())) {
            shows.forEach {
                TvView(it, selected = selected == it.id) {
                    selected =
                        if (selected == it.id) null
                        else it.id
                }
            }
        }
    }
}
