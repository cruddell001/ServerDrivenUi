package com.example.thatconference.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.VideoCameraBack
import androidx.compose.material.icons.filled.Weekend
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.example.thatconference.R

@Composable
fun TabBarHost(controller: NavHostController) {
    var selectedTab by remember { mutableStateOf(TabItem.Movies.ordinal) }
    Column(Modifier.fillMaxSize()) {
        AppNavHost(navController = controller, Modifier.fillMaxSize().weight(1f))
        TabRow(selectedTabIndex = selectedTab) {
            Tab(selected = selectedTab == TabItem.Movies.ordinal, onClick = {
                selectedTab = TabItem.Movies.ordinal
                controller.navigate(Route.Movies)
            }) {
                TabView(tab = TabItem.Movies)
            }
            Tab(selected = selectedTab == TabItem.TvShows.ordinal, onClick = {
                selectedTab = TabItem.TvShows.ordinal
                controller.navigate(Route.TvShows)
            }) {
                TabView(tab = TabItem.TvShows)
            }
        }
    }
}

@Composable
private fun TabView(tab: TabItem) {
    val title = stringResource(id = tab.title)
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(tab.icon, title)
        Text(title)
    }
}

enum class TabItem(@StringRes val title: Int, val icon: ImageVector) {
    Movies(R.string.movies, Icons.Default.VideoCameraBack),
    TvShows(R.string.tv, Icons.Default.Weekend),
    Favorites(R.string.favorites, Icons.Default.Favorite)
}
