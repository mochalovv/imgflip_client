package ru.vmochalov.memegenerator.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.visible(visible: Boolean, useGone: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else if (useGone) View.GONE else View.INVISIBLE
}