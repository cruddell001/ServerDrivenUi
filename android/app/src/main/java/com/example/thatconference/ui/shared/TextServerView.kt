package com.example.thatconference.ui.shared


import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.thatconference.models.ui.TextView

@Composable
fun TextServerView(data: TextView) {
    val modifier = Modifier.padding(data.padding.dp)
    val style = TextStyle(
        color = Color(android.graphics.Color.parseColor(data.color)),
        fontSize = data.fontSize.sp,
        fontWeight = if (data.bold) FontWeight.Bold else FontWeight.Normal,
        fontStyle = if (data.italic) FontStyle.Italic else FontStyle.Normal
    )
    Text(
        text = data.text,
        modifier = modifier,
        style = style,
        maxLines = if (data.wrapText) Int.MAX_VALUE else 1,
        overflow = if (data.wrapText) TextOverflow.Ellipsis else TextOverflow.Clip
    )

}
