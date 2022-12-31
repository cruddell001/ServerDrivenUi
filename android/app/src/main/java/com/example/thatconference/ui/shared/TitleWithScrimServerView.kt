package com.example.thatconference.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.sp
import com.example.thatconference.models.ui.TitleWithScrimView

@Composable
fun TitleWithScrimServerView(data: TitleWithScrimView) {
    TitleWithScrimView(
        text = data.text,
        fontSize = data.fontSize.sp,
        textWrap = data.wrapText
    )
}
