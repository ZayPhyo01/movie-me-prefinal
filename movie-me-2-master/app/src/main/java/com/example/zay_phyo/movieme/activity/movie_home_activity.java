package com.example.zay_phyo.movieme.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.drawable.DrawerArrowDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.Repository.Repository;
import com.example.zay_phyo.movieme.Utils.RoundedTabHelper;
import com.example.zay_phyo.movieme.adapter.RecyclerAdapter.MovieResultAdpater;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.fragment.UiFragment;


import com.example.zay_phyo.movieme.fragment.Upcoming_fragment;
import com.facebook.shimmer.ShimmerFrameLayout;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class movie_home_activity extends AppCompatActivity {
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout linearLayout;
    MovieResultAdpater movieResultAdpater;
    LinearLayoutManager linearLayoutManager;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    UiFragment uiFragment;
    RelativeLayout network_root;
    TextView retry;
    View v[] = new View[3];
    Toolbar toolbar;
    DrawerArrowDrawable drawerArrowDrawable;
    ActionBarDrawerToggle actionBarDrawerToggle;
    Upcoming_fragment upcoming_fragment;
    LinearLayout l1,l2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_home_activity);
        uiFragment = (UiFragment) UiFragment.getInstance(AppConstants.FIRST_PAGE, this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        drawerLayout=findViewById(R.id.drawer);
        upcoming_fragment= (Upcoming_fragment) Upcoming_fragment.getInstance(this);
l2=  findViewById(R.id.upcoming_tab_root);
l1=  findViewById(R.id.root_view);


        drawerArrowDrawable = new DrawerArrowDrawable(this);

           toolbar = findViewById(R.id.tool);
           setSupportActionBar(toolbar);


          getSupportActionBar().setHomeButtonEnabled(true);
          getSupportActionBar().setDisplayHomeAsUpEnabled(true);


          actionBarDrawerToggle=  new ActionBarDrawerToggle(this,drawerLayout,toolbar,
               R.string.dopen,
                R.string.dclose) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
                Log.i("drawer","ok");
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
               invalidateOptionsMenu();
            }
        };

        actionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        fragmentTransaction.add(R.id.root_view, uiFragment).commit();

        linearLayout = findViewById(R.id.tab_root);
        RoundedTabHelper roundedTabHelper = new RoundedTabHelper(this, linearLayout);
        roundedTabHelper.RoundedTabHelperListener(new RoundedTabHelper.RoundedTabLayoutListener() {
            @Override
            public void onClick(int i) {
                Log.v("Position test : ", i + "");

                switch (i) {
                    case 1:
                        l1.setVisibility(View.VISIBLE);
                        Log.d("tab pos ",i+"");
                        getSupportFragmentManager().beginTransaction().replace(R.id.root_view, uiFragment).commit();

                        l2.setVisibility(View.GONE);
                      // Toast.makeText(movie_home_activity.this,"do it 1",Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        l2.setVisibility(View.VISIBLE);
                        Log.d("tab pos ",i+"");
                        getSupportFragmentManager().beginTransaction().replace(R.id.upcoming_tab_root,upcoming_fragment ).commit();

                        l1.setVisibility(View.GONE);
                        break;
                }

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        actionBarDrawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"Press back again",Toast.LENGTH_SHORT).show();
    }


}
