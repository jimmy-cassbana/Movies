package com.jimmy.movies.presentation.movies.list

import com.jimmy.movies.base.AppBaseFragment
import com.jimmy.movies.databinding.FragmentMovieListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieListFragment :
    AppBaseFragment<FragmentMovieListBinding>(FragmentMovieListBinding::inflate) {
}