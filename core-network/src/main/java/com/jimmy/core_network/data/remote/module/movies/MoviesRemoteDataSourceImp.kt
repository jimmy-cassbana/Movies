package com.jimmy.core_network.data.remote.module.movies

import com.jimmy.core_arch.CoroutineDispatchers
import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_network.data.remote.model.MoviesResponse
import com.jimmy.core_network.ext.getDataState
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MoviesRemoteDataSourceImp @Inject constructor(
    private val api: MoviesApi,
    private val coroutineDispatchers: CoroutineDispatchers
): MoviesRemoteDataSource {
    override suspend fun getMovies(): DataState<MoviesResponse> =
        withContext(coroutineDispatchers.io) {
            api.getMovies().getDataState()
        }

}