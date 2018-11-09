package com.example.zay_phyo.movieme.viewholder;

import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class MovieResultHolder extends BaseHolder<MovieResult> {
ImageView imageView;
TextView title,rate;

    public MovieResultHolder(View itemView1, MovieDetailController movieDetailController,List<MovieResult>movieResults) {
        super(itemView1,movieDetailController,movieResults);
        imageView=itemView1.findViewById(R.id.image);
        title=itemView1.findViewById(R.id.title);

        rate=itemView1.findViewById(R.id.rate);

    }

    @Override
    public void bind(int position) {
        Log.v("viewholder","true");
String cut=movieResults.get(position).getOriginal_title();
if(cut.length()<=12) {
    title.setText(cut);
}else
{
    cut=cut.substring(0,12)+" ...";
    title.setText(cut);
}

        rate.setText(movieResults.get(position).getVote_average());
        Glide.with(itemView.getContext())
        .load(AppConstants.GLIDE_IMAGE_URL +movieResults.get(position).getPoster_path())


        .thumbnail(0.1f).into(imageView);


    }


}
