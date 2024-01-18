package com.example.movieappagain.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieappagain.databinding.ItemListerBinding;
import com.example.movieappagain.model.Result;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {


    private Context context;
    private ArrayList<Result> movieArrayList;

    public MovieAdapter(Context context, ArrayList<Result> movieArrayList) {
        this.context = context;
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListerBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()), R.layout.item_lister, parent, false);
        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        Result result = movieArrayList.get(position);
        holder.movieList.setMovie(result);

    }

    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{
        public MovieViewHolder(ItemListerBinding movieListItemBinding) {
            super(movieListItemBinding.getRoot());
            this.movieList = movieListItemBinding;

            movieList.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    int position = getAdapterPosition();
                }
            });
        }



        private ItemListerBinding movieList;



    }
}
