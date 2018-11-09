package com.example.zay_phyo.movieme.viewholder;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.BaseModel;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;

import java.util.List;


public class CompanyHolder extends BaseHolder <ProductionCompany> {

    TextView name;
    ImageView imageView;

    public CompanyHolder(View itemView, List<ProductionCompany> companies) {
        super(itemView, companies);
        name = itemView.findViewById(R.id.company_title);
        imageView = itemView.findViewById(R.id.company_imgae);
    }

    @Override
    public void bind(int position) {


        if (movieResults.get(position).getLogo_path() != null) {
            name.setText(movieResults.get(position).getName());
            name.setTextColor(Color.BLACK);
            Glide.with(itemView.getContext())
                    .load(AppConstants.GLIDE_IMAGE_URL + movieResults.get(position).getLogo_path())
                    .into(imageView);

        } else {

            name.setText("No Logo");
            name.setTextColor(Color.RED);
            imageView.setBackgroundResource(R.drawable.time_rounded);

        }
    }
}
