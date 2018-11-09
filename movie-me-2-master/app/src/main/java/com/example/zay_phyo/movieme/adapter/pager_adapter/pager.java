package com.example.zay_phyo.movieme.adapter.pager_adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

public class pager extends PagerAdapter {
    Context context;
    View[]views=new View[3];
    public pager(Context context,View[]view) {
        views=view;
        this.context=context;
    }

    @Override
    public int getCount() {
        return views.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }


    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=new View(context);
        switch (position)
        {
            case 0:
                view=views[0];
                break;
            case 1:
                view=views[1];
                break;
            case 2:
                view=views[2];
        }
       ViewPager viewPager= (ViewPager)container;
        viewPager.addView(view,position);
        return  view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ViewPager viewPager = (ViewPager) container;
        View view = (View) object;
        viewPager.removeView(view);
    }

}
