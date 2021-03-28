package com.github.pierry.eazytensions

import android.graphics.Paint
import android.widget.Button

object EazyWidgets {

  fun Button.underline() {
    this.paintFlags = this.paintFlags or Paint.UNDERLINE_TEXT_FLAG
  }
}