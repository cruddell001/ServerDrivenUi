package com.example.thatconference.ui.shared

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.thatconference.models.ui.CardView

@Composable
fun CardServerView(data: CardView, modifier: Modifier = Modifier) {
    Card(modifier.fillMaxWidth().padding(8.dp)) {
        data.content.Composable()
    }
}
