package com.example.zay_phyo.movieme.mvp.presenter;

import android.content.Context;
import android.widget.Toast;

import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.view.popular_view;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;
//@neveruse
public class Presenter implements get_popular_list_presenter{
popular_view pv;
Context context;

    public Presenter(Context context,popular_view pv) {
    this.context=context;
    this.pv=pv;
        EventBus.getDefault().register(this);

    }



    @Override
    public void get_popular_list(List<MovieResult> listOfresult) {


    }



}
