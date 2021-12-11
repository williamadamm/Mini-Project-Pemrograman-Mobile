package com.example.miniproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.miniproject.models.Movie
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(
    private val movies : List<Movie>,
    val listener : onAdapterListener
): RecyclerView.Adapter<MovieAdapter.MovieViewHolder>(){

    class MovieViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
       return MovieViewHolder(
           LayoutInflater.from(parent.context).inflate(R.layout.movie_item,parent,false)
       )
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {

        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        val movie = movies[position]
        holder.itemView.movie_title.text = movie.title
        holder.itemView.movie_release_date.text = movie.release
        holder.itemView.movie_overview.text = movie.overview

        Glide.with(holder.itemView).load(IMAGE_BASE + movie.poster).into(holder.itemView.movie_poster)

        holder.itemView.setOnClickListener{
            listener.onClick(movie)
        }
    }

    override fun getItemCount(): Int = movies.size

    interface onAdapterListener{
        fun onClick(movie: Movie)
    }
}
