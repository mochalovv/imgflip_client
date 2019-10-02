package ru.vmochalov.memegenerator.extension

import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager

fun View.visible(visible: Boolean, useGone: Boolean = true) {
    this.visibility = if (visible) View.VISIBLE else if (useGone) View.GONE else View.INVISIBLE
}

fun View.showKeyboard() {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (requestFocus()) imm.showSoftInput(this, 0)
}

fun View.hideKeyboard(clearFocus: Boolean = false) {
    if (clearFocus) {
        clearFocus()
    }
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(windowToken, 0)
}