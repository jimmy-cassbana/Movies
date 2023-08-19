package com.jimmy.movies.presentation.movies.details

import com.jimmy.movies.base.AppBaseFragment
import com.jimmy.movies.databinding.FragmentMovieDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    AppBaseFragment<FragmentMovieDetailsBinding>(FragmentMovieDetailsBinding::inflate) {

    override fun init() {
        super.init()
    }
}