package com.jimmy.core_network.data.remote.model

import com.google.gson.annotations.SerializedName

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("poster_path")
    private val posterPath: String
) {
    fun getImage() = "https://image.tmdb.org/t/p/w500/$posterPath"
}
