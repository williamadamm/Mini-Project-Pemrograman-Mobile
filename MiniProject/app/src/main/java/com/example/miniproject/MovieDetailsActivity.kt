package com.example.miniproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.miniproject.R
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val IMAGE_BASE = "https://image.tmdb.org/t/p/w500/"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        movie_title_details.text = intent.getStringExtra("Movie_title")
        movie_overview_details.text = intent.getStringExtra("Movie_overview")
        Glide.with(this).load(IMAGE_BASE+intent.getStringExtra("Movie_poster")).into(movie_poster_details)

    }
}