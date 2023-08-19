package com.jimmy.core_network.data.remote.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("poster_path")
    private val posterPath: String
) : Parcelable {
    fun getYear() = date.split("-").first()
    fun getImage() = "https://image.tmdb.org/t/p/w500/$posterPath"
}
