package com.jimmy.movies.presentation.movies.list

import com.jimmy.core_arch.ViewState
import com.jimmy.core_network.data.remote.model.MoviesResponse

data class MovieListViewState(
    val loading: Boolean = false,
    val result: MoviesResponse? = null,
    val error: Throwable? = null
) : ViewState
