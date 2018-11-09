package com.example.zay_phyo.movieme.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;

import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.Utils.NetWorkUtil;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.MovieResultAdpater;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.NowPlayingAdapter;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.PopularMovieAdapter;
import com.example.zay_phyo.movieme.api.movieapi.movie_api_interface;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.data.movie_response.BaseResponse;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.presenter.Presenter;
import com.example.zay_phyo.movieme.mvp.presenter.movie_list_home_presenter;
import com.example.zay_phyo.movieme.mvp.view.movie_list_home_view;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;

public class UiFragment extends android.support.v4.app.Fragment implements movie_list_home_view, View.OnClickListener, SwipeRefreshLayout.OnRefreshListener, MovieDetailController {
    @BindView(R.id.shimmer_top_rated)
    ShimmerFrameLayout shimmer_top_rated;

    @BindView(R.id.shimmer_now_playing)
    ShimmerFrameLayout shimmer_now_playing;

    @BindView(R.id.shimmer_popular)
    ShimmerFrameLayout shimmer_popular_playing;

    @BindView(R.id.list_view)
    RecyclerView top_rated_list;

    @BindView(R.id.now_playing_list_view)
    RecyclerView now_playing_list;

    @BindView(R.id.popular_playing_list_view)
    RecyclerView popular_list;

    static Context context;

    MovieResultAdpater movieResultAdpater;

    NowPlayingAdapter nowPlayingAdapter;

    PopularMovieAdapter popularMovieAdapter;

    static UiFragment uiFragment;

    @BindView(R.id.showMore)
    TextView showMore;

    @BindView(R.id.refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.network_root)
    RelativeLayout network_root;

    @BindView(R.id.online_view_fs_page)
    RelativeLayout onlineView;

    Snackbar snackbar;
    boolean isOnline=true;
    movie_list_home_presenter movie_list_home_presenter;

    //For intent activity when click
    boolean online_available=true;


    public static android.support.v4.app.Fragment getInstance(int mCategory, Context context1) {

        uiFragment = new UiFragment();
        Bundle bundle = new Bundle();
        context = context1;

        bundle.putInt("key", mCategory);
        uiFragment.setArguments(bundle);

        return uiFragment;

    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = LayoutInflater.from(context).inflate(R.layout.top_rated_fragment, container, false);

        ButterKnife.bind(this, view);

        RefreshHelper();


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        snackbar = Snackbar.make(view, "online mode", 1000);

        showMore = view.findViewById(R.id.showMore);
        showMore.setText(Html.fromHtml("<u>Show More</u>"));

//Here Presenter init.......................
         movie_list_home_presenter = new movie_list_home_presenter(context, this);


        super.onViewCreated(view, savedInstanceState);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {


        initAdapter();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            swipeRefreshLayout.setProgressViewOffset(false, 0, 300);
        }

        showMore.setOnClickListener(this);
        movieResultAdpater.isShowMore(false);

        Log.v("adapter is ", "create");


        top_rated_list.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        now_playing_list.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        popular_list.setLayoutManager(new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false));
        popular_list.setAdapter(popularMovieAdapter);
        top_rated_list.setAdapter(movieResultAdpater);
        now_playing_list.setAdapter(nowPlayingAdapter);


        //Check Network here......................
        if (movie_list_home_presenter.isOnline()) {



        } else {


            Repository.DbTopMovie.getData();

         /*   onlineView.setVisibility(View.INVISIBLE);
            network_root.setVisibility(View.VISIBLE);*/
        }

        super.onActivityCreated(savedInstanceState);
    }


    @Override
    public void horizontal_list_data(List<MovieResult> list) {

        top_rated_list.setVisibility(View.VISIBLE);


        movieResultAdpater.removeall();
        movieResultAdpater.setData(list);
        top_rated_list.setAdapter(movieResultAdpater);

        onlineView.setVisibility(View.VISIBLE);
        network_root.setVisibility(View.INVISIBLE);

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }


    @Override
    public void vertical_list_data(List<MovieResult> list) {


        //  movieResultAdpater.notifyDataSetChanged();
        //  Toast.makeText(context,": "+list.get(0).getId()+"",Toast.LENGTH_SHORT).show();


        nowPlayingAdapter.setData(list);
        onlineView.setVisibility(View.VISIBLE);
        network_root.setVisibility(View.INVISIBLE);
        now_playing_list.setVisibility(View.VISIBLE);
        nowPlayingAdapter.notifyDataSetChanged();
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }


    }

    @Override
    public void show_Horizontal_Shimmer() {

        shimmer_top_rated.startShimmerAnimation();
    }

    @Override
    public void hide_Horizontl_Shimmer() {

        shimmer_top_rated.stopShimmerAnimation();
        shimmer_top_rated.setVisibility(View.GONE);
    }

    @Override
    public void show_vertical_Shimmer() {

        shimmer_now_playing.startShimmerAnimation();
    }

    @Override
    public void hide_vertical_Shimmer() {
        shimmer_now_playing.stopShimmerAnimation();
        shimmer_now_playing.setVisibility(View.GONE);
    }

    @Override
    public void show_twoOf_list() {


    }

    @Override
    public void fail_top_rated() {

        onlineView.setVisibility(View.INVISIBLE);

        network_root.setVisibility(View.VISIBLE);
        swipeRefreshLayout.setRefreshing(false);


    }

    @Override
    public void fail_now_playing() {
        swipeRefreshLayout.setRefreshing(false);
        onlineView.setVisibility(View.INVISIBLE);
        network_root.setVisibility(View.VISIBLE);


    }

    @Override
    public void fail_popular() {
        swipeRefreshLayout.setRefreshing(false);
        onlineView.setVisibility(View.INVISIBLE);
        network_root.setVisibility(View.VISIBLE);


    }

    @Override
    public void show_popular_shimmer() {

    }

    @Override
    public void hide_popular_shimmer() {
        shimmer_popular_playing.stopShimmerAnimation();
        shimmer_popular_playing.setVisibility(View.GONE);
    }

    @Override
    public void popular_list_data(List<MovieResult> list) {
        Log.v("popular list", "work");
        onlineView.setVisibility(View.VISIBLE);
        network_root.setVisibility(View.INVISIBLE);

        popular_list.setVisibility(View.VISIBLE);
        Collections.reverse(list);
        popularMovieAdapter.setData(list);

        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }


    }

    @Override
    public void isOnline() {
        snackbar.setText("Online Mode");

        snackbar.show();
        network_root.setVisibility(View.INVISIBLE);
        onlineView.setVisibility(View.VISIBLE);
    }

    @Override
    public void isOffline() {
        snackbar.setText("offline mode");
        swipeRefreshLayout.clearAnimation();

        //Query from database in first time.So it doesn't need when refresh
        snackbar.show();
        Log.v("offline", "true");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.showMore
                    :
                movieResultAdpater.isShowMore(true);

                movieResultAdpater.notifyDataSetChanged();
        }
    }




    @Override
    public void onRefresh() {

        Repository.DetalMovieDb.delete();

        if(!movie_list_home_presenter.isOnline())
        {
            swipeRefreshLayout.setRefreshing(false);
        }else {
            shimmer_top_rated.startShimmerAnimation();
            movie_list_home_presenter.LoadData();
        }
    }

    private void RefreshHelper() {

        swipeRefreshLayout.setOnRefreshListener(this);

        swipeRefreshLayout.setSoundEffectsEnabled(true);
    }


    void initAdapter() {
        movieResultAdpater = new MovieResultAdpater(context, this);
        nowPlayingAdapter = new NowPlayingAdapter(context, this);
        popularMovieAdapter = new PopularMovieAdapter(context, this);

    }

    @Override
    public void moiveDetailListener(String movie_id) {
        Log.d("onclick","work");
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        Bundle bundle = new Bundle();

        intent.putExtra("getFromFragment", movie_id);
        startActivity(intent);
        Log.d("movie detail list ", movie_id + "");
    }


}
