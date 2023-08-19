package com.jimmy.movies.presentation.movies.list

import com.jimmy.core_arch.domain.DataState
import com.jimmy.core_arch.presentation.viewmodel.MVIBaseViewModel
import com.jimmy.movies.domain.usecase.GetMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class MovieListViewModel @Inject constructor(
    private val getMoviesUseCase: GetMoviesUseCase
) : MVIBaseViewModel<MovieListAction, MovieListResult, MovieListViewState>() {
    override val defaultViewState: MovieListViewState
        get() = MovieListViewState()

    override fun handleAction(action: MovieListAction): Flow<MovieListResult> {
        return flow {
            when(action) {
                is MovieListAction.GetMovieList -> handleActionOfGetMovies(this)
            }
        }
    }

    private suspend fun handleActionOfGetMovies(flowCollector: FlowCollector<MovieListResult>) {
        try {
            flowCollector.emit(MovieListResult.Loading)
            val dataState = getMoviesUseCase.invoke()
            if (dataState is DataState.Success)
                dataState.data.let {
                    flowCollector.emit(MovieListResult.Success(it))
                }
            else if (dataState is DataState.Error) {
                flowCollector.emit(MovieListResult.Failure(dataState.throwable))
            }
        } catch (error: Throwable) {
            flowCollector.emit(MovieListResult.Failure(error))
        }
    }

}