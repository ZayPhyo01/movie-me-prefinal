package com.example.zay_phyo.movieme.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.CompanyAdapter;
import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;
import com.example.zay_phyo.movieme.mvp.presenter.MovieDetailPresenter;
import com.example.zay_phyo.movieme.mvp.view.moive_detail_view;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class detail_fragment extends android.support.v4.app.Fragment implements moive_detail_view {

    @BindView(R.id.detail_poster)
    ImageView detail_poster;

    @BindView(R.id.detail_title)
    TextView detail_title;

    @BindView(R.id.runtime)
    TextView runtime;

    @BindView(R.id.release_date)
    TextView release_date;

    @BindView(R.id.more_button)
    Button more_button;

    @BindView(R.id.detail_overview)
    TextView detail_overview;

    @BindView(R.id.company_list)
    RecyclerView company_list;

    @BindView(R.id.detail_tagline)
    TextView detail_tagline;

    @BindView(R.id.detail_rating)
    TextView detail_rating;

    CompanyAdapter companyAdapter;

    Toast toast;



    static Context context;

    public static detail_fragment getInstance(Context context1, int moive_id) {
        context = context1;
        detail_fragment detail_fragment = new detail_fragment();
        Bundle bundle = new Bundle();
        bundle.putString(AppConstants.MOVIE_ID, String.valueOf(moive_id));
        detail_fragment.setArguments(bundle);
        return detail_fragment;


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(context).inflate(R.layout.detail_fragment, container, false);

        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {




        MovieDetailPresenter movieDetailPresenter = new MovieDetailPresenter(this);

        movieDetailPresenter.Presenter_LoadHelper(getArguments().getString(AppConstants.MOVIE_ID));

        company_list.setLayoutManager(new LinearLayoutManager(context));

        companyAdapter = new CompanyAdapter(context);
        Log.i("after company","adapter");

        company_list.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));

        company_list.setAdapter(companyAdapter);


        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void detail_imgae_url(String url) {
        if (url != null) {
            Glide.with(context)
                    .load(AppConstants.GLIDE_IMAGE_URL + url)
                    .thumbnail(0.1f).into(detail_poster);
        }
    }

    @Override
    public void detail_title(String title) {
        if (title != null)
            detail_title.setText(title);

    }

    @Override
    public void detail_time(String time) {
        if (time != null) {
            int hour = Integer.parseInt(time) / 60;
            int minute = Integer.parseInt(time) % 60;
            runtime.setText(hour + " hr : " + minute + " min ");
        }
    }

    @Override
    public void detail_date(String date) {
        if (date != null)
            release_date.setText(date.replace("-", " - "));
    }

    @Override
    public void detail_homepage(String url) {
        if (url != null) {
            more_button.setVisibility(View.VISIBLE);
            final Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            more_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(intent);
                }
            });

        } else {
            more_button.setVisibility(View.GONE);
        }
        //  context.startActivity(intent);

    }

    @Override
    public void detail_overview(String overview) {
        if (overview != null)
            detail_overview.setText(overview);

    }

    @Override
    public void detail_company(List<ProductionCompany> productionCompanyList) {
        companyAdapter.setData(productionCompanyList);
        companyAdapter.notifyDataSetChanged();
        company_list.setVisibility(View.VISIBLE);
    }

    @Override
    public void detail_fail() {


    }

    @Override
    public void detail_tag_line(String tagline) {
        detail_tagline.setText(tagline);
    }

    @Override
    public void detail_rate(String rate) {
        detail_rating.setText("Rating : " + rate);

    }
}
