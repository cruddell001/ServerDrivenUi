package com.example.thatconference.ui.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleWithScrimView(
    text: String,
    fontSize: TextUnit = 20.sp,
    textWrap: Boolean = true
) {
    Box(Modifier.fillMaxWidth().background(Color.Black.copy(alpha = 0.4f))) {
        if (textWrap) {
            Text(
                text = text,
                style = TextStyle(fontSize = fontSize, color = Color.White),
                modifier = Modifier.padding(4.dp)
            )
        } else {
            Text(
                text = text,
                style = TextStyle(fontSize = fontSize, color = Color.White),
                modifier = Modifier.padding(4.dp),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1
            )
        }
    }
}