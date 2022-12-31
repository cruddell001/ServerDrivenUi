package com.example.thatconference.ui.screens.television

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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.thatconference.models.TvShow
import com.example.thatconference.ui.shared.ColumnSpacer
import com.example.thatconference.ui.shared.FullWidthImage
import com.example.thatconference.ui.shared.TitleWithScrimView

@Composable
fun TvView(show: TvShow, selected: Boolean, onClick: () -> Unit) {
    Card(Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = onClick)) {
        Column {
            Box(Modifier.height(IntrinsicSize.Min)) {
                val imageUrl = show.backdropImage.ifEmpty { show.posterImage }
                FullWidthImage(imageUrl, show.name, 150.dp)
                Column(Modifier.fillMaxHeight()) {
                    ColumnSpacer()
                    TitleWithScrimView(text = show.name)
                }
            }

            AnimatedVisibility(visible = selected) {
                Box(Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(show.description, style = TextStyle(fontSize = 16.sp))
                }
            }
        }

    }
}
