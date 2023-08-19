package com.jimmy.movies.presentation.movies.list

import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.jimmy.movies.base.AppBaseFragment
import com.jimmy.movies.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MovieListFragment :
    AppBaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {

    private val viewModel: MovieListViewModel by viewModels()

    override fun init() {
        super.init()
        viewModel.executeAction(MovieListAction.GetMovieList)
    }

    override fun subscribe() {
        super.subscribe()
        lifecycleScope.launchWhenCreated {
            viewModel.viewStates.onEach { viewState -> handleViewState(viewState) }.collect()
        }
    }

    private fun handleViewState(viewState: MovieListViewState) {
        setLoading(viewState.loading)
        when {
            viewState.result != null -> {
                Toast.makeText(
                    requireContext(),
                    viewState.result.results.first().title,
                    Toast.LENGTH_SHORT
                ).show()
            }

            viewState.error != null -> {
                handleError(viewState.error)
            }
        }
    }

    private fun setLoading(loading: Boolean) {
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }
}

