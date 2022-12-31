package com.example.thatconference.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.thatconference.models.ui.BoxView

@Composable
fun BoxServerView(data: BoxView) {
    var modifier: Modifier = Modifier.padding(data.padding.dp)
    if (data.fullWidth) modifier = modifier.then(Modifier.fillMaxWidth())
    if (!data.bgColor.isNullOrEmpty()) modifier =
        modifier.then(Modifier.background(Color(android.graphics.Color.parseColor(data.bgColor))))
    if (data.constrainHeight) modifier = modifier.then(Modifier.height(IntrinsicSize.Min))
    Box(modifier) {
        data.items.forEach {
            it.Composable()
        }
    }
}
