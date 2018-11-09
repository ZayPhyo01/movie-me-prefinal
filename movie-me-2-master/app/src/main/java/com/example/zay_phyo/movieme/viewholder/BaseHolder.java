package com.example.zay_phyo.movieme.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.BaseModel;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.List;

public abstract class BaseHolder<T extends BaseModel> extends RecyclerView.ViewHolder implements View.OnClickListener {
    MovieDetailController movieDetailController;
    List<T> movieResults;

    public BaseHolder(View itemView, List<T> movieResults) {
        super(itemView);
        this.movieResults = movieResults;
    }

    public BaseHolder(View itemView, MovieDetailController movieDetailController, List<T> movieResults) {
        super(itemView);

            itemView.setOnClickListener(this);


        this.movieResults = movieResults;
        this.movieDetailController = movieDetailController;
    }

    public abstract void bind(int position);

    @Override
    public void onClick(View view) {
        if(movieResults.get(getAdapterPosition()).getId()!=null)
        movieDetailController.moiveDetailListener(movieResults.get(getAdapterPosition()).getId());
    }
}
