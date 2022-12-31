package com.example.thatconference.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.thatconference.models.ui.FullWidthImageView

@Composable
fun FullWidthImageServerView(data: FullWidthImageView) {
    FullWidthImage(data.imageUrl, data.contentDescription, data.height.dp)
}
