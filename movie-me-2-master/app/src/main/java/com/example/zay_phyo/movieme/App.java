package com.example.zay_phyo.movieme;

import android.app.Application;

import com.example.zay_phyo.movieme.Persistance.Dbinstance;
import com.example.zay_phyo.movieme.data.retrofit.Retrofit_Helper;



import retrofit2.Retrofit;

public class App extends Application {
static App app;


    @Override
    public void onCreate() {
        super.onCreate();
        app=this;

    }

   public Retrofit getRetrofit()
   {
       return Retrofit_Helper.getRetrofitInstance();
   }

   public static App getApp()
   {
       return app;
   }

   public  Dbinstance getDatabase()
   {
       return Dbinstance.getInstance(getApplicationContext());
   }


}
