package com.example.miniproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.miniproject.models.Movie
import com.example.miniproject.models.MovieResponse
import com.example.miniproject.sevice.MovieApiInterface
import com.example.miniproject.sevice.MovieApiService
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rv_movies_list.layoutManager = LinearLayoutManager(this)
        rv_movies_list.setHasFixedSize(true)
        getMovieData { movies : List<Movie> ->
            rv_movies_list.adapter = MovieAdapter(movies,object :MovieAdapter.onAdapterListener{
                override fun onClick(movie: Movie) {
//                    Toast.makeText(applicationContext, movie.title, Toast.LENGTH_SHORT).show()

                    startActivity(
                        Intent(applicationContext,MovieDetailsActivity::class.java)
                            .putExtra("Movie_title", movie.title)
                            .putExtra("Movie_overview",movie.overview)
                            .putExtra("Movie_poster",movie.poster)
                    )

                }


            })
        }
    }

    private fun getMovieData(Callback:(List<Movie>) -> Unit){

        val apiService = MovieApiService.getInstance().create(MovieApiInterface::class.java)
        apiService.getMovieList().enqueue(object : Callback<MovieResponse>{
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                return Callback(response.body()!!.result)
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {

            }

        })
    }

}