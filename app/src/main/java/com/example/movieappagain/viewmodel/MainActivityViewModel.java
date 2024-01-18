package com.example.movieappagain.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.movieappagain.model.ModelRepository;
import com.example.movieappagain.model.Result;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private ModelRepository repository;


    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new ModelRepository(application);
    }

    public LiveData<List<Result>> getAllMovies(){
        return repository.getMutableLiveData();
    }
}
