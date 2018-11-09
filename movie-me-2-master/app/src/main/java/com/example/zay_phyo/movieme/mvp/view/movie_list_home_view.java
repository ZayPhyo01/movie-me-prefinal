package com.example.zay_phyo.movieme.mvp.view;

import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.List;

public interface movie_list_home_view {


    public void horizontal_list_data(List<MovieResult> list);

    public void vertical_list_data(List<MovieResult> list);

    public void show_Horizontal_Shimmer();

    public void hide_Horizontl_Shimmer();

    public void show_vertical_Shimmer();

    public void hide_vertical_Shimmer();

    public void show_twoOf_list();

    public void fail_top_rated();

    public void fail_now_playing();

    public void fail_popular();

    public void show_popular_shimmer();

    public void hide_popular_shimmer();

    public void popular_list_data(List<MovieResult> list);

    public void isOnline();

    public void isOffline();


}
