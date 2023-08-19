package com.jimmy.movies.presentation.movies.details

import androidx.navigation.fragment.navArgs
import com.jimmy.movies.base.AppBaseFragment
import com.jimmy.movies.databinding.FragmentMovieDetailsBinding
import com.jimmy.movies.util.showImage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailsFragment :
    AppBaseFragment<FragmentMovieDetailsBinding>(FragmentMovieDetailsBinding::inflate) {

    private val args: MovieDetailsFragmentArgs by navArgs()

    override fun init() {
        super.init()
        args.movie.apply {
            binding.apply {
                ivPoster.showImage(getImage())
                tvName.text = title
                tvYear.text = getYear()
                tvOverview.text = overview
            }
        }
    }
}