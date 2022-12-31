package com.example.thatconference.ui.shared

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.thatconference.models.ui.ColumnView
import com.example.thatconference.models.ui.ListView

@Composable
fun ListServerView(data: ListView) {
    var selectedItem by remember { mutableStateOf(-1) }
    Column(Modifier.verticalScroll(rememberScrollState())) {
        data.items.forEachIndexed { index, item ->
            item.Composable(Modifier.clickable {
                selectedItem = if (selectedItem == index) -1 else index
                item.selected.value = selectedItem == index
                data.items.forEachIndexed { i2, view ->
                    if (i2 != index) view.selected.value = false
                }
            })
        }
    }
}
