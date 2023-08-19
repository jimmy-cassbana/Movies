package com.jimmy.movies.domain.usecase

import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_arch.domain.ISuspendableUseCase
import com.jimmy.core_data.domain.repository.MoviesRepository
import com.jimmy.core_network.data.remote.model.MoviesResponse
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MoviesRepository
) : ISuspendableUseCase.WithoutParams<DataState<MoviesResponse>> {
    override suspend fun invoke(): DataState<MoviesResponse> =
        repository.getMovies()

}