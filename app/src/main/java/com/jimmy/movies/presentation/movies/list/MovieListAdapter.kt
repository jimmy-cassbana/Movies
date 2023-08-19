package com.jimmy.movies.presentation.movies.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jimmy.core_network.data.remote.model.Movie
import com.jimmy.movies.databinding.MovieItemBinding
import com.jimmy.movies.util.showImage

class MovieListAdapter(
    private val dataSet: List<Movie>,
    private val itemClickListener: (item: Movie) -> Unit,
) :
    RecyclerView.Adapter<MovieListAdapter.ViewHolder>() {

    class ViewHolder(private val binding: MovieItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Movie) {
            binding.apply {
                tvName.text = item.title
                tvYear.text = item.getYear()
                ivPoster.showImage(item.getImage())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(dataSet[position])
        holder.itemView.setOnClickListener {
            itemClickListener(dataSet[position])
        }
    }

    override fun getItemCount() = dataSet.size

}
