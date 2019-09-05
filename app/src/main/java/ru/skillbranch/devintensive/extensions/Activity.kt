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

fun Activity.isKeyboardOpen(): Boolean {

    val rootView = findViewById<View>(android.R.id.content)
    val visibleBorders = Rect()

    rootView.getWindowVisibleDisplayFrame(visibleBorders)

    val heightDiff = rootView.getRootView().getHeight() - (visibleBorders.bottom - visibleBorders.top);
    return heightDiff > 50
}

fun Activity.isKeyboardClosed(): Boolean {
    return !this.isKeyboardOpen()
}
