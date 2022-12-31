package com.example.thatconference.ui.screens.television

import android.util.Log
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
import com.example.thatconference.models.ui.GenericServerView
import com.example.thatconference.models.ui.ServerView
import com.example.thatconference.repository.DataRepository
import com.example.thatconference.ui.screens.movies.MovieView
import com.example.thatconference.ui.shared.Composable

@Composable
fun TvList() {
    var shows by remember { mutableStateOf<List<TvShow>>(emptyList()) }
    var serverUi: ServerView by remember { mutableStateOf(GenericServerView()) }
    var selected by remember { mutableStateOf<Long?>(null) }

    LaunchedEffect(key1 = Unit) {
        shows = DataRepository.popularShows()
        serverUi = DataRepository.tvShowsAsUi()
        Log.d("TvList", "server ui: ${serverUi.javaClass.canonicalName}")
    }

    Box(Modifier.fillMaxSize().background(Color.LightGray)) {
        serverUi.Composable()
//        Column(Modifier.verticalScroll(rememberScrollState())) {
//            movies.forEach {
//                TvView(it, selected = selected == it.id) {
//                    selected =
//                        if (selected == it.id) null
//                        else it.id
//                }
//            }
//        }
    }
}
