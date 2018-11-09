package com.example.zay_phyo.movieme.fragment;

import android.graphics.LinearGradient;
import android.support.design.internal.NavigationMenuItemView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.zay_phyo.movieme.R;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        String movie_id= (String) getIntent().getExtras().get("getFromFragment");
      //  Log.i("movie id",movie_id);
        detail_fragment detail_fragment= com.example.zay_phyo.movieme.fragment.detail_fragment.getInstance(this,Integer.parseInt(movie_id));
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.detail_root,detail_fragment);
        fragmentTransaction.commit();



    }
}
