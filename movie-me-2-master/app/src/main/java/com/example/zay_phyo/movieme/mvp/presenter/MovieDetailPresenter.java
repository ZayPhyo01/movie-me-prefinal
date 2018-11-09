package com.example.zay_phyo.movieme.mvp.presenter;

import android.util.Log;

import com.example.zay_phyo.movieme.Persistance.DbModel.Detail;
import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.data.DetailConvector;
import com.example.zay_phyo.movieme.data.movie_response.DetailResponse;
import com.example.zay_phyo.movieme.event.detailevent;
import com.example.zay_phyo.movieme.mvp.view.moive_detail_view;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MovieDetailPresenter {

    moive_detail_view mDetail;


    public MovieDetailPresenter(moive_detail_view moive_detail_view) {
        this.mDetail=moive_detail_view;
        EventBus.getDefault().register(this);


    }

    public void Presenter_LoadHelper(String movie_id)
    {




Repository.DetalMovieDb.getData(Integer.parseInt(movie_id));


    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void getDetailMovie(detailevent detailevent)
    {
        if(detailevent.isSuccess())
        {

            DetailConvector detailConvector=detailevent.getDetailConvector();
            mDetail.detail_date(detailConvector.getRelease_date());
            mDetail.detail_time(detailConvector.getRuntime());
            mDetail.detail_homepage(detailConvector.getHomepage());
            mDetail.detail_imgae_url(detailConvector.getPoster_path());
            mDetail.detail_overview(detailConvector.getOverview());
            mDetail.detail_tag_line(detailConvector.getTagline());
            mDetail.detail_rate(detailConvector.getVote_average());
            mDetail.detail_title(detailConvector.getTitle());

            mDetail.detail_company(detailevent.getDetailConvector().getProduction_companies());


        }
        else
            mDetail.detail_fail();


EventBus.getDefault().unregister(this);
    }
}
/*
void detail_imgae_url(String url);
 void detail_title(String title);
 void detail_time(String time);
 void detail_date(String date);
 void detail_homepage(String url);//More button use
 void detail_overview(String overview);
 void detail_company(List<ProductionCompany>productionCompanyList);
 */