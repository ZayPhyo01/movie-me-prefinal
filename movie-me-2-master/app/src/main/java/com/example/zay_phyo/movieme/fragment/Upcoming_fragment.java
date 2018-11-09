package com.example.zay_phyo.movieme.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.Utils.NetWorkUtil;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.MovieResultAdpater;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.presenter.upcoming_movie_presenter;
import com.example.zay_phyo.movieme.mvp.view.movie_upcoming_ivew;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Upcoming_fragment extends Fragment implements movie_upcoming_ivew ,MovieDetailController,SwipeRefreshLayout.OnRefreshListener {



    RecyclerView upcomingList;


    ShimmerFrameLayout shimmerFrameLayout;


    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;

    MovieResultAdpater movieResultAdpater;
    upcoming_movie_presenter upcoming_movie_presenter;
static  Context context;
public static  android.support.v4.app.Fragment  getInstance(Context context1)
{

    context=context1;
    return new Upcoming_fragment();
}


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
     View view=LayoutInflater.from(context).inflate(R.layout.upcoming_fragment,container,false);


        return view;



    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    shimmerFrameLayout=view.findViewById(R.id.shimmer_top_rated_up);
    swipeRefreshLayout=view.findViewById(R.id.refresh_up);
    upcomingList=view.findViewById(R.id.list_view_up);
    relativeLayout=view.findViewById(R.id.network_root);
        shimmerFrameLayout.startShimmerAnimation();

        Log.d("upcoming presenter","start");
        upcoming_movie_presenter=new upcoming_movie_presenter(context,this);



        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        movieResultAdpater=new MovieResultAdpater(context,this);

        swipeRefreshLayout.setOnRefreshListener(this);

        if(NetWorkUtil.isOnline(context)) {
            upcoming_movie_presenter.LoadData();
            relativeLayout.setVisibility(View.GONE);
        }
        else{
            relativeLayout.setVisibility(View.VISIBLE);
            shimmerFrameLayout.setVisibility(View.GONE);
        }
        upcomingList.setLayoutManager(new GridLayoutManager(context,2));
        upcomingList.setAdapter(movieResultAdpater);


    super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void success(List<MovieResult> movieResults) {

//Log.d("success get",movieResults.get(0).original_title);


        relativeLayout.setVisibility(View.GONE);
    movieResultAdpater.setData(movieResults);
    movieResultAdpater.notifyDataSetChanged();
    shimmerFrameLayout.setVisibility(View.GONE);
    shimmerFrameLayout.stopShimmerAnimation();
    swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void fail() {
    upcomingList.setVisibility(View.GONE);


    swipeRefreshLayout.setRefreshing(false);
    shimmerFrameLayout.stopShimmerAnimation();
    shimmerFrameLayout.setVisibility(View.GONE);
    relativeLayout.setVisibility(View.VISIBLE);

    }

    @Override
    public void moiveDetailListener(String movie_id) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();

        intent.putExtra("getFromFragment", movie_id);
        startActivity(intent);
    }

    @Override
    public void onRefresh() {
        upcoming_movie_presenter.LoadData();
    }
}
