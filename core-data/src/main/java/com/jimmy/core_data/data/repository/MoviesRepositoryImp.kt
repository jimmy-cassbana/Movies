package com.jimmy.core_data.data.repository

import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_data.domain.repository.MoviesRepository
import com.jimmy.core_network.data.remote.model.MoviesResponse
import com.jimmy.core_network.data.remote.module.movies.MoviesRemoteDataSource
import javax.inject.Inject

class MoviesRepositoryImp @Inject constructor(
    private val remoteDataSource: MoviesRemoteDataSource
) : MoviesRepository {
    override suspend fun getMovies(): DataState<MoviesResponse> = remoteDataSource.getMovies()
}