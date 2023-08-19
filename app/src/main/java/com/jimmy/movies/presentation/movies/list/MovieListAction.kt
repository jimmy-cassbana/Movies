package com.jimmy.movies.presentation.movies.list

import com.jimmy.core_arch.Action

sealed class MovieListAction : Action {
    object GetMovieList : MovieListAction()
}