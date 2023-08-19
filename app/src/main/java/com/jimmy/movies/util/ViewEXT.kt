package com.jimmy.movies.util

import android.view.View
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}