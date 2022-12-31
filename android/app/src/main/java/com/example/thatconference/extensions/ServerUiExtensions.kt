package com.example.thatconference.extensions

import com.example.thatconference.models.ui.*

fun ServerView.parentSelected(): Boolean {
    return parentSelectedRecursive() ?: false
}

fun ServerView.setParent() {
    setParentRecursive()
}

private fun ServerView.setParentRecursive() {
    val children = when (this) {
        is AnimatedVisibility -> listOf(this.content)
        is BoxView -> this.items
        is CardView -> listOf(this.content)
        is ColumnView -> this.items
        is ListView -> this.items
        else -> emptyList()
    }
    children.forEach {
        it.parent = this
        it.setParent()
    }
}

private fun ServerView.parentSelectedRecursive(): Boolean? {
    if (parent == this) return null
    return if (parent?.selected?.value == true) true
    else parent?.parentSelectedRecursive()
}
