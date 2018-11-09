package com.example.zay_phyo.movieme.data.movie_response;

import android.util.Log;


import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.offline_result;
import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class BaseResponse<T extends event>{

 T event1;
 Call<MovieConvector>movieConvectorCall;


   public BaseResponse(T event,Call<MovieConvector>convectorCall ) {
        this.event1 = event;
        movieConvectorCall=convectorCall;

    }

    public void  get_movie_result()
    {
        Log.v("work","top rated");
        movieConvectorCall

                .enqueue(new Callback<MovieConvector>() {
                    @Override
                    public void onResponse(retrofit2.Call<MovieConvector> call, Response<MovieConvector> response) {
                        MovieConvector movieConvector=response.body();
                        Log. v("Now playing ","work");

                        if(movieConvector!=null) {
                            Log.v("Retrofit work","true");

                            event1.setMovieConvector(movieConvector);
                            event1.setSuccess(true);

                            EventBus.getDefault().post(event1);

                            movieCallback(movieConvector.getResults());

/*if(response1==0)
{
    DbTob dbTob=new DbTob();

    List<offline_result>offline_results=new ArrayList<>();
    for(int i=0;i<movieConvector.getResults().size();i++) {
        offline_result offline_result=new offline_result();
        offline_result.setVote_count_offline(movieConvector.getResults().get(i).getVote_count());
        offline_result.setVote_average_offline(movieConvector.getResults().get(i).getVote_average());
        offline_result.setPoster_path_offline(movieConvector.getResults().get(i).getPoster_path());
        offline_result.setRelease_date_offline(movieConvector.getResults().get(i).getRelease_date());
        offline_result.setOriginal_title_offline(movieConvector.getResults().get(i).getOriginal_title());
        offline_result.setPopularity_offline(movieConvector.getResults().get(i).getPopularity());
        offline_results.add(offline_result);


    }


        dbTob.setOffline_results_db(offline_results);
        Repository.DbTopMovie.insertData(dbTob);

}*/





                        }

                    }

                    @Override
                    public void onFailure(retrofit2.Call<MovieConvector> call, Throwable t) {
                        EventBus.getDefault().post(new event.NowPlayingResponseEvent(null,false));
                        Log. v("Now playing ","fail");

                    }
                });


    }
    public abstract void movieCallback(List<MovieResult>movieResults);



}
