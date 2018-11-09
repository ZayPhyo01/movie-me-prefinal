package com.example.zay_phyo.movieme.data.movie_response;

import android.util.Log;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.Persistance.DbModel.Detail;
import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.api.movieapi.movie_api_interface;
import com.example.zay_phyo.movieme.data.DetailConvector;
import com.example.zay_phyo.movieme.event.detailevent;
import com.example.zay_phyo.movieme.event.event;

import org.greenrobot.eventbus.EventBus;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailResponse {


    public static void getMoiveDetail(String id)
    {
       movie_api_interface movie_api_interface= App.getApp().getRetrofit().create(movie_api_interface.class);
       final Call<DetailConvector>detailConvector= movie_api_interface.get_detail_movie(id,AppConstants.MY_API);
       detailConvector.enqueue(new Callback<DetailConvector>() {
           @Override
           public void onResponse(Call<DetailConvector> call, Response<DetailConvector> response) {
               DetailConvector detailConvector1=response.body();
             Log.d("Detail Convector is ",detailConvector1.getPoster_path());
             detailevent detailevent1=new detailevent();
             detailevent1.setDetailConvector(detailConvector1);
             detailevent1.setSuccess(true);
               if(detailConvector!=null)
               {
                   Detail detail=new Detail();

                   detail.setHomepage(detailConvector1.getHomepage());
                   detail.setPoster_path(detailConvector1.getPoster_path());
                   detail.setId(Integer.parseInt(detailConvector1.getId()));

                   detail.setOriginal_language(detailConvector1.getOriginal_language());
                   detail.setOriginal_title(detailConvector1.getOriginal_title());
                   detail.setOverview(detailConvector1.getOverview());

                   detail.setProduction_companies(detailConvector1.getProduction_companies());
                   detail.setRelease_date(detailConvector1.getRelease_date());
                   detail.setRuntime(detailConvector1.getRuntime());
                   detail.setTitle(detailConvector1.getTitle());

                   detail.setTagline(detailConvector1.getTagline());
                   detail.setVote_average(detailConvector1.getVote_average());


                   Log.d("id",detail.getId()+"");
                   Log.d("overView",detail.getOverview());



                   Repository.DetalMovieDb.insertData(detail);
                   EventBus.getDefault().post(detailevent1);
                   Log.d("detailres ","ok");
               }
           }

           @Override
           public void onFailure(Call<DetailConvector> call, Throwable t) {

               EventBus.getDefault().post(new detailevent());
           }
       });



    }

}
