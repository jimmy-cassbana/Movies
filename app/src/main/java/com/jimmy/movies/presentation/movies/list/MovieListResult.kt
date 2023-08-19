package com.jimmy.movies.presentation.movies.list

import com.jimmy.core_network.data.remote.model.MoviesResponse

sealed class MovieListResult: com.jimmy.core_arch.Result<MovieListViewState>{

    object Loading : MovieListResult() {
        override fun reduce(
            defaultState: MovieListViewState,
            oldState: MovieListViewState
        ) = defaultState.copy(loading = true)
    }

    data class Success(val result: MoviesResponse) : MovieListResult() {
        override fun reduce(
            defaultState: MovieListViewState,
            oldState: MovieListViewState
        ) = defaultState.copy(
            loading = false,
            result = result
        )
    }

    data class Failure(val error: Throwable) : MovieListResult() {
        override fun reduce(
            defaultState: MovieListViewState,
            oldState: MovieListViewState
        ) = defaultState.copy(
            loading = false,
            error = error
        )
    }

}