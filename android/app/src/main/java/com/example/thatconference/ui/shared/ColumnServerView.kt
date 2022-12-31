package com.example.thatconference.ui.shared

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.thatconference.models.ui.ColumnView

@Composable
fun ColumnServerView(data: ColumnView) {
    Column {
        data.items.forEach {
            if (it.isSpacer()) ColumnSpacer()
            else it.Composable()
        }
    }
}
