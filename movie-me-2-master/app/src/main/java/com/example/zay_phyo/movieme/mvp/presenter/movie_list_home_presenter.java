package com.example.zay_phyo.movieme.mvp.presenter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbNowPlaying;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbPopular;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.offline_result;
import com.example.zay_phyo.movieme.Persistance.ListHelper;
import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.Utils.NetWorkUtil;
import com.example.zay_phyo.movieme.api.movieapi.movie_api_interface;
import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.data.movie_response.BaseResponse;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.view.movie_list_home_view;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class movie_list_home_presenter {
    movie_list_home_view mListHome;
    Context context;
    private boolean isOnline;

    public movie_list_home_presenter(Context context, movie_list_home_view mListHome) {
        this.context = context;
        this.mListHome = mListHome;
        mListHome.show_vertical_Shimmer();
        mListHome.show_Horizontal_Shimmer();
        mListHome.show_popular_shimmer();
        EventBus.getDefault().register(this);

        if (isOnline()) {
            LoadData();
            mListHome.isOnline();

        } else {
            mListHome.isOffline();
            Repository.DbTopMovie.getData();
            Repository.DbNowMovie.getData();
            Repository.DbPopularMovie.getData();
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getListHome(event.TopRatedMovieResponse rated) {
        List<MovieResult> list = new ArrayList<>();
        list = rated.getMovieConvector().getResults();
      //  Log.i("is Success "," "+rated.isSuccess());
      //  Log.i("rate size "," "+rated.getMovieResults().size());

        if (rated.isSuccess() && list.size() != 0) {


            mListHome.horizontal_list_data(list);
            mListHome.hide_Horizontl_Shimmer();

        } else {

            mListHome.fail_top_rated();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getNowPlaying(event.NowPlayingResponseEvent nowPlayingResponseEvent) {

        List<MovieResult> list = new ArrayList<>();

        list = nowPlayingResponseEvent.getMovieConvector().getResults();
        if (nowPlayingResponseEvent.isSuccess() && list.size() != 0) {


            mListHome.vertical_list_data(list);
            mListHome.hide_vertical_Shimmer();
        } else {
            if (list.size() == 0) {
                mListHome.isOffline();
            }

            mListHome.fail_now_playing();
        }


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getPopularPlaying(event.PopularResponseEvent popularResponseEvent) {
        List<MovieResult> list = new ArrayList<>();

        list = popularResponseEvent.getMovieConvector().getResults();

        if (popularResponseEvent.isSuccess() && list.size() != 0) {


            mListHome.popular_list_data(list);
            mListHome.hide_popular_shimmer();

        } else {
            if (list.size() == 0) {
                mListHome.isOffline();
            }
            mListHome.fail_popular();
        }


    }

    public static void LoadData() {


        ResponseHelper();


    }

    private static void ResponseHelper() {
        // Top_Rating_Response.get_movie_result();
        // Now_Playing_Response.get_movie_result();

        BaseResponse<event.NowPlayingResponseEvent> nowPlayingResponseEventBaseResponse =
                new BaseResponse<event.NowPlayingResponseEvent>(new event.NowPlayingResponseEvent(),
                        (Call<MovieConvector>) App.getApp().getRetrofit().create(movie_api_interface.class).get_movie_convector_now_playing(AppConstants.MY_API)) {
                    @Override
                    public void movieCallback(List<MovieResult> list) {
                        List<offline_result> offline_results = ListHelper.Online_Offline.convertToTop(list);
                        DbNowPlaying dbNowPlaying = new DbNowPlaying();
                        dbNowPlaying.setOffline_results_db(offline_results);
                        Repository.DbNowMovie.insertData(dbNowPlaying);
                    }
                };
        nowPlayingResponseEventBaseResponse.get_movie_result();


        BaseResponse<event.TopRatedMovieResponse> topratedresponse =
                new BaseResponse<event.TopRatedMovieResponse>(new event.TopRatedMovieResponse(),
                        (Call<MovieConvector>) App.getApp().getRetrofit().create(movie_api_interface.class).get_movie_convector(AppConstants.MY_API)) {
                    @Override
                    public void movieCallback(List<MovieResult> list) {
                        List<offline_result> offlie_results = ListHelper.Online_Offline.convertToTop(list);

                        Log.i("top rate is ","success");


                        DbTob dbTob = new DbTob();
                        dbTob.setOffline_results_db(offlie_results);
                        Repository.DbTopMovie.insertData(dbTob);
                    }
                };
        topratedresponse.get_movie_result();


        BaseResponse<event.PopularResponseEvent> popular_response =
                new BaseResponse<event.PopularResponseEvent>(new event.PopularResponseEvent(),
                        (Call<MovieConvector>) App.getApp().getRetrofit().create(movie_api_interface.class).get_popular_movie(AppConstants.MY_API)) {
                    @Override
                    public void movieCallback(List<MovieResult> list) {
                        List<offline_result> offline_results = ListHelper.Online_Offline.convertToTop(list);
                        DbPopular dbPopular = new DbPopular();
                        dbPopular.setOffline_results_db(offline_results);
                        Repository.DbPopularMovie.insertData(dbPopular);

                        Log.v("callback list ", list.size() + "");
                    }
                };
        popular_response.get_movie_result();


    }

    private static void DatabaseHelper() {


        // Repository.OfflineRepoTop.getData();
        //    Repository.OfflinePopular.getData();
        //   Repository.OfflineRepoNow.getData();


    }

    public boolean isOnline() {
        return NetWorkUtil.isOnline(context);
    }


}
