package com.github.pierry.eazytensions

import android.content.Context
import java.text.Normalizer

object EazyText {

  private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

  fun String.normalize(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
  }

  fun Int.convertToText(context: Context): String {
    return context.getString(this)
  }

  fun ArrayList<Int>.stringify(): String {
    var msg = ""
    this.forEach { item ->
      msg += "${item}\n"
    }
    return msg
  }
}