package com.example.zay_phyo.movieme.adapter.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zay_phyo.movieme.R;
import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;
import com.example.zay_phyo.movieme.viewholder.CompanyHolder;

public class CompanyAdapter extends BaseAdapter<CompanyHolder,ProductionCompany> {

    public CompanyAdapter(Context context) {

        super(context);
        Log.i("init","company adapter");
    }

    @Override
    public void onBindViewHolder(@NonNull CompanyHolder holder, int position) {
        holder.bind(position);

        Log.i("Company holder","ok");


    }


    @NonNull
    @Override
    public CompanyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.production_companies_list,parent,false);
        Log.i("Company create view","ok");
        return new CompanyHolder(view,getListOfitem());
    }
}
