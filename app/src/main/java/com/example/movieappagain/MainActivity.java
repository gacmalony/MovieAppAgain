package com.example.movieappagain;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;


import com.example.movieappagain.model.Result;
import com.example.movieappagain.view.MovieAdapter;
import com.example.movieappagain.viewmodel.MainActivityViewModel;
import com.mastercoding.themovieapp.R;
import com.mastercoding.themovieapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Result> movies;
    private RecyclerView recycle;
    private MovieAdapter adapter;
    private SwipeRefreshLayout refreshLayout;
    private ActivityMainBinding binding;
    private MainActivityViewModel viewModel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding = DataBindingUtil
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        
        viewModel = new ViewModelProvider(this)
                .get(MainActivityViewModel.class);

        refreshLayout = binding.swiperefresh;
        refreshLayout.setColorSchemeResources(R.color.black);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                getPopularMovies();
            }
        });


        }
    private void getPopularMovies(){

        viewModel.getAllMovies().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(List<Result> results) {
                movies = (ArrayList<Result>) results;
                displayMoviesInRecyclerView();
            }
        });
    }


    private void displayMoviesInRecyclerView(){
        recycle = binding.recyclerkaan;
        adapter = new MovieAdapter(this, movies);

        recycle.setItemAnimator(new DefaultItemAnimator());
        recycle.setAdapter(adapter);

        recycle.setLayoutManager(new GridLayoutManager(this, 2));

    }
}