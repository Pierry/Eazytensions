package com.github.pierry.eazytensions

import android.graphics.Bitmap
import java.io.ByteArrayOutputStream
import kotlin.math.min

object EazyIO {

  private const val QUALITY = 100

  fun Bitmap.toByteArray(): ByteArray {
    val stream = ByteArrayOutputStream()
    this.compress(Bitmap.CompressFormat.PNG, QUALITY, stream)
    return stream.toByteArray()
  }

  fun Bitmap.resizeBitmap(
    width: Int,
    height: Int
  ): Bitmap? {
    var source = this
    if (source.height == height && source.width == width) return source
    val maxLength = min(width, height)
    return try {
      source = source.copy(source.config, true)
      if (source.height <= source.width) {
        if (source.height <= maxLength) {
          return source
        }
        val aspectRatio = source.width.toDouble() / source.height.toDouble()
        val targetWidth = (maxLength * aspectRatio).toInt()
        Bitmap.createScaledBitmap(source, targetWidth, maxLength, false)
      } else {
        if (source.width <= maxLength) {
          return source
        }
        val aspectRatio = source.height.toDouble() / source.width.toDouble()
        val targetHeight = (maxLength * aspectRatio).toInt()
        Bitmap.createScaledBitmap(source, maxLength, targetHeight, false)
      }
    } catch (e: Exception) {
      source
    }
  }
}