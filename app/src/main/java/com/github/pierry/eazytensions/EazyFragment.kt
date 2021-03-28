package com.github.pierry.eazytensions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar

object EazyFragment {

  fun Fragment.onNavigate(directions: NavDirections) {
    findNavController().navigate(directions)
  }

  fun Fragment.onNavigate(directions: NavDirections, args: Bundle) {
    findNavController().navigate(directions.actionId, args)
  }

  fun View.snackbar(message: CharSequence) = Snackbar.make(this, message, Snackbar.LENGTH_SHORT).apply { show() }
}