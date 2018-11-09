package com.example.zay_phyo.movieme.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.List;

public class PopularMoiveHolder extends BaseHolder<MovieResult> {
    TextView textView;
    ImageView imageView;
    public PopularMoiveHolder(View itemView, MovieDetailController movieDetailController, List<MovieResult>movieResults) {
        super(itemView,movieDetailController,movieResults);
        textView=itemView.findViewById(R.id.now_playing_title);
        imageView=itemView.findViewById(R.id.now_playing_image);
    }

    @Override
    public void bind(int position) {

        textView.setText(movieResults.get(position).getOriginal_title());



        Glide.with(itemView.getContext())
                .load(AppConstants.GLIDE_IMAGE_URL +movieResults.get(position).getPoster_path())
                .error(R.drawable.time_rounded)
                .placeholder(R.drawable.time_rounded)

                .thumbnail(0.1f).into(imageView);

    }

}
