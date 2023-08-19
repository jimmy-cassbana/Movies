package com.jimmy.movies.util

import android.view.View
import android.widget.ImageView
import com.bumptech.glide.Glide

fun View.gone() {
    this.visibility = View.GONE
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun ImageView.showImage(url:String) {
    Glide.with(this.context)
        .load(url)
        .into(this)
}