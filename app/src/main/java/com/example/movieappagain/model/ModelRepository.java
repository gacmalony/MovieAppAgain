package com.example.movieappagain.model;

import static com.mastercoding.themovieapp.BR.movie;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.example.movieappagain.serviceapi.MovieApiService;
import com.example.movieappagain.serviceapi.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ModelRepository {


    ArrayList<Result> result = new ArrayList<>();

    private MutableLiveData<List<Result>> mutableLiveData = new MutableLiveData<>();

    private Application application;
    public ModelRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Result>> getMutableLiveData(){
        MovieApiService movieApiService = RetrofitInstance.getService();

        Call<Movie> call = movieApiService.getPopularMovies("615a37c659b8418d82c945323bbf40d4");
        call.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                Movie movie = response.body();

                if (movie != null && movie.getResults() != null){
                    result = (ArrayList<Result>) movie.getResults();
                    mutableLiveData.setValue(result);
                }

            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
            }
        });
        return mutableLiveData;
    }
}
