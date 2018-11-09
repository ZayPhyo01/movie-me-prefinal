package com.example.zay_phyo.movieme.adapter.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.viewholder.MovieResultHolder;

import java.util.List;

public class MovieResultAdpater extends BaseAdapter<MovieResultHolder,MovieResult> {


    public MovieResultAdpater(Context context, MovieDetailController movieDetailController) {
        super(context, movieDetailController);
    }

    @NonNull
    @Override
    public MovieResultHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.top_rated_horizontal,parent,false);

        return new MovieResultHolder(view,movieDetailController,getListOfitem());
    }

    @Override
    public void onBindViewHolder(@NonNull MovieResultHolder holder, int position) {

          holder.bind(position);


          }


}
