package com.example.zay_phyo.movieme.mvp.presenter;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.api.movieapi.movie_api_interface;
import com.example.zay_phyo.movieme.data.movie_response.BaseResponse;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.view.movie_upcoming_ivew;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;

public class upcoming_movie_presenter {


    Context context;
    movie_upcoming_ivew movie_upcoming_view;

    public upcoming_movie_presenter(Context context,movie_upcoming_ivew movie_upcomint_view) {
        this.context = context;
        this.movie_upcoming_view=movie_upcomint_view;
        EventBus.getDefault().register(this);
    }


    @Subscribe
    public void getResult(event.UpComingMovieResponse upComingMovieResponse)
    {
        if(upComingMovieResponse.isSuccess()) {


            Log.d("Upcoming","success");

           movie_upcoming_view.success(upComingMovieResponse.getMovieConvector().getResults());





        }
        else
        {
            movie_upcoming_view.fail();


        }




    }






    public static void LoadData()
    { Log.d("upcoming callback","work");
        BaseResponse<event.UpComingMovieResponse>baseResponse=
                new BaseResponse<event.UpComingMovieResponse>(new event.UpComingMovieResponse(),
                        App.getApp().getRetrofit()
                        .create(movie_api_interface.class)
                .get_upcoming_movie(AppConstants.MY_API)) {
            @Override
            public void movieCallback(List<MovieResult> movieResults) {


                Log.d("upcoming callback","work");
                Log.d("upcoming callback","work");
                Log.d("upcoming callback","work");
            }
        };
        baseResponse.get_movie_result();



    }


}
