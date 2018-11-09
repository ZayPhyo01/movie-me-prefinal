package com.example.zay_phyo.movieme.data.retrofit;

import com.example.zay_phyo.movieme.Constants.AppConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retrofit_Helper {


    private static Retrofit retrofit;

    private static OkHttpClient client()
    {
        OkHttpClient.Builder okHttpClient=new OkHttpClient().newBuilder();
        okHttpClient.connectTimeout(5000,TimeUnit.SECONDS);
        okHttpClient.readTimeout(5000,TimeUnit.SECONDS);
        return okHttpClient.build();

    }

    public static Retrofit getRetrofitInstance() {
        if (retrofit == null) {
            retrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(AppConstants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client())
                    .build();
        }
        return retrofit;
    }


}
