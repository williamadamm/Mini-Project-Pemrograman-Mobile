package com.example.miniproject

import android.content.Intent
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

        share_iv.setOnClickListener{
            val message : String = "Hey! i got some movie for you! \n\n" + intent.getStringExtra("Movie_title") + "\n\n" + "Here's the overview!\n" + intent.getStringExtra("Movie_overview")

            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type = "text/plain"

            startActivity(Intent.createChooser(intent,"Share to:"))

        }


    }
}