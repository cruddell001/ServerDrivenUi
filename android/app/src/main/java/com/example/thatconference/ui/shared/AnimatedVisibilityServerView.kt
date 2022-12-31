package com.example.thatconference.ui.shared

import android.util.Log
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import com.example.thatconference.extensions.parentSelected
import com.example.thatconference.models.ui.AnimatedVisibility

@Composable
fun AnimatedVisibilityServerView(data: AnimatedVisibility) {
    AnimatedVisibility(visible = data.selected.value || data.parentSelected()) {
        data.content.Composable()
    }
}
