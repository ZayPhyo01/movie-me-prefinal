package com.example.zay_phyo.movieme.adapter.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.viewholder.PopularMoiveHolder;

public class PopularMovieAdapter extends BaseAdapter<PopularMoiveHolder,MovieResult> {


    public PopularMovieAdapter(Context context, MovieDetailController movieDetailController) {
        super(context, movieDetailController);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularMoiveHolder holder, int position) {
        super.onBindViewHolder(holder, position);
       holder.bind(position);
        Log.i("adapter for popular","ok");


    }

    @NonNull
    @Override
    public PopularMoiveHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=(LayoutInflater.from(context).inflate(R.layout.popular_ui_list,parent,false));
       return new PopularMoiveHolder(view,movieDetailController,getListOfitem());
    }
}
