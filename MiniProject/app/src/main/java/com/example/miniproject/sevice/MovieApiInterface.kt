package com.example.miniproject.sevice

import com.example.miniproject.models.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiInterface {

    @GET("movie/popular?api_key=ba9cac46b8aa862fb6fe83185416f2f1")
    fun getMovieList(): Call<MovieResponse>
}
