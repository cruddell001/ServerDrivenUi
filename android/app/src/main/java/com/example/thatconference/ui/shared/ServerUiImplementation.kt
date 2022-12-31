package com.example.thatconference.ui.shared

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thatconference.models.ui.*

@Composable
fun ServerView.Composable(modifier: Modifier = Modifier) {
    when (this) {
        is ColumnView -> ColumnServerView(data = this)
        is BoxView -> BoxServerView(data = this)
        is CardView -> CardServerView(data = this, modifier)
        is FullWidthImageView -> FullWidthImageServerView(data = this)
        is TitleWithScrimView -> TitleWithScrimServerView(data = this)
        is ListView -> ListServerView(data = this)
        is AnimatedVisibility -> AnimatedVisibilityServerView(data = this)
        is TextView -> TextServerView(data = this)
        else -> Box(Modifier)
    }
}

fun ServerView.isSpacer(): Boolean = this is SpacerView
