package com.github.pierry.eazytensions

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream

object EazyIO {

  private const val QUALITY = 100

  fun Bitmap.toByteArray(): ByteArray {
    val stream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, QUALITY, stream)
    return stream.toByteArray()
  }
}