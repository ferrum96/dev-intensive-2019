package ru.skillbranch.devintensive.extensions

import android.app.Activity
import android.content.Context
import android.graphics.Rect
import android.view.View
import android.view.inputmethod.InputMethodManager

fun Activity.hideKeyboard() {
    hideKeyboard(if (currentFocus == null) View(this) else currentFocus)
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}

fun Activity.isKeyboardOpen(v: View): Boolean {
    val rect = Rect()
    v.getWindowVisibleDisplayFrame(rect)
    val heightDiff: Int = v.rootView.height - (rect.bottom - rect.top)
    return heightDiff > 100
}

fun Activity.isKeyboardClosed(v: View): Boolean = !this.isKeyboardOpen(v)