package com.example.thatconference.ui.shared

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ColumnScope.ColumnSpacer() {
    Spacer(modifier = Modifier.fillMaxHeight().weight(1f))
}

@Composable
fun RowScope.RowSpacer() {
    Spacer(modifier = Modifier.fillMaxWidth().weight(1f))
}