package com.example.zay_phyo.movieme.adapter.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.viewholder.NowPlayingHolder;

public class NowPlayingAdapter extends BaseAdapter<NowPlayingHolder,MovieResult> {


    public NowPlayingAdapter(Context context, MovieDetailController movieDetailController) {
        super(context, movieDetailController);
    }

    @NonNull
    @Override
    public NowPlayingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.now_playing,parent,false);

        Log.i("Nowplaying adpater","work");
        return new NowPlayingHolder(view,movieDetailController,getListOfitem());
    }

    @Override
    public void onBindViewHolder(@NonNull NowPlayingHolder holder, int position) {
        super.onBindViewHolder(holder, position);
        holder.bind(position);

    }
}
