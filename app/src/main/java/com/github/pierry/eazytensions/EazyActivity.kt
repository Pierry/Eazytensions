package com.github.pierry.eazytensions

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager

object EazyActivity {

  fun Activity.hideKeyboard() {
    val imm: InputMethodManager = this.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    var view = this.currentFocus
    if (view == null) {
      view = View(this)
    }
    imm.hideSoftInputFromWindow(view.windowToken, 0)
  }
}