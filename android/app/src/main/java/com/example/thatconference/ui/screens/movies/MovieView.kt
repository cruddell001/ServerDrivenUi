package com.example.thatconference.ui.screens.movies

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.thatconference.models.Movie
import com.example.thatconference.ui.shared.ColumnSpacer
import com.example.thatconference.ui.shared.FullWidthImage
import com.example.thatconference.ui.shared.TitleWithScrimView

@Composable
fun MovieView(movie: Movie, selected: Boolean, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = onClick)) {
        Column {
            Box(Modifier.height(IntrinsicSize.Min)) {
                val imageUrl = movie.backdropImage.ifEmpty { movie.posterImage }
                FullWidthImage(imageUrl, movie.title, 150.dp)
                Column(Modifier.fillMaxHeight()) {
                    ColumnSpacer()
                    TitleWithScrimView(text = movie.title)
                }
            }

            AnimatedVisibility(visible = selected) {
                Box(Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(movie.description, style = TextStyle(fontSize = 16.sp))
                }
            }
        }
    }
}
