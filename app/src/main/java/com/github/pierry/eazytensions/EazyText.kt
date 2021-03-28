package com.github.pierry.eazytensions

import java.text.Normalizer

object EazyText {

  private val REGEX_UNACCENT = "\\p{InCombiningDiacriticalMarks}+".toRegex()

  fun String.normalize(): String {
    val temp = Normalizer.normalize(this, Normalizer.Form.NFD)
    return REGEX_UNACCENT.replace(temp, "")
  }
}