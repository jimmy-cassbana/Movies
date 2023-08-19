package com.jimmy.core_network.data.remote.module.movies

import com.jimmy.core_network.data.remote.model.MoviesResponse
import retrofit2.Response
import retrofit2.http.GET

interface MoviesApi {

    @GET("discover/movie")
    suspend fun getMovies(): Response<MoviesResponse>
}