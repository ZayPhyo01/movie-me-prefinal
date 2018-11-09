package com.example.zay_phyo.movieme.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

//never use
public abstract class base_activity extends AppCompatActivity {

    abstract int getLayout();
    abstract void doProcess();


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState );
        setContentView(getLayout());

        doProcess();


    }

}
