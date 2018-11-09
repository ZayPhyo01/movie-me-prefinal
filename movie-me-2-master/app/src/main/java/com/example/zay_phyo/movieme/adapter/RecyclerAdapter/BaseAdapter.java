package com.example.zay_phyo.movieme.adapter.RecyclerAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.example.zay_phyo.movieme.controller.MovieDetailController;
import com.example.zay_phyo.movieme.viewholder.BaseHolder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BaseAdapter<T extends BaseHolder,W> extends RecyclerView.Adapter<T> {
Context context;
List<W>listOfitem;

boolean showMore=true;

MovieDetailController movieDetailController;

    public BaseAdapter(Context context) {
        this.context = context;
    }

    public BaseAdapter(Context context, MovieDetailController movieDetailController)
    {

        this.context=context;

        this.movieDetailController=movieDetailController;
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        Log.i("Time of create adapter"," * ");
        if(listOfitem==null)
            Log.i("List value ","null");
        else
            Log.i("List value","not null");
    }

    @Override
    public int getItemCount() {

        if(listOfitem!=null)
            if(showMore)
        return listOfitem.size();
            else return 4;
        else

            return 0;
    }

  public   void setData(List<W>data) {
      if (data != null) {
          listOfitem = data;
       notifyDataSetChanged();
      }

  }

  public void removeall() { listOfitem=new ArrayList<>(); }
  public void isShowMore(boolean showMore)
  {
      this.showMore=showMore;
  }

  public List<W>getListOfitem()
    {
        if(listOfitem!=null)

        return (listOfitem.size()==0) ? new ArrayList<W>() : listOfitem;
        else
            return new ArrayList<>();
    }

}
