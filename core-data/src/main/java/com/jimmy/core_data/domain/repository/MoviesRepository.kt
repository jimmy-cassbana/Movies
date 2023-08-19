package com.jimmy.core_data.domain.repository

import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_network.data.remote.model.MoviesResponse

interface MoviesRepository {
    suspend fun getMovies(): DataState<MoviesResponse>
}