package com.jimmy.core_network.data.remote.module.movies

import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_network.data.remote.model.MoviesResponse

interface MoviesRemoteDataSource {
    suspend fun getMovies(): DataState<MoviesResponse>
}