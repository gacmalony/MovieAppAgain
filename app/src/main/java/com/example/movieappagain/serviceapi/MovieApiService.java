package com.example.movieappagain.serviceapi;

import com.example.movieappagain.model.Movie;

import javax.xml.transform.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApiService {

    @GET("movie/popular")
    Call<Movie> getPopularMovies(@Query("api_key") String apiKey);
}
