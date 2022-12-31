package com.example.models.ui

fun TitleWithScrimView(
    text: String,
    fontSize: Int = 20,
    wrapText: Boolean = false,
    color: String = "#ffffff"
): ServerView {
    return BoxView(
        items = listOf(
            TextView(
                text = text,
                fontSize = fontSize,
                color = color,
                wrapText = wrapText,
                padding = 4
            )
        ),
        bgColor = "#66000000"
    )
}