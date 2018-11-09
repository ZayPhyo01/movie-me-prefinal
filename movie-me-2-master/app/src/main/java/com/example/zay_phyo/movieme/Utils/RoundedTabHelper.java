package com.example.zay_phyo.movieme.Utils;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.R;

public class RoundedTabHelper implements View.OnClickListener {
    Context context;
    View[] barview=new View[3];
    ImageView imageView[]=new ImageView[3];
    Animation tarnslate;
    int old_place=0;
    int new_place;

    TextView tab[]=new TextView[2];


    int id[] = new int[2];
    LinearLayout linearLayout;
    RoundedTabLayoutListener roundedTabLayoutListener;

    public RoundedTabHelper(Context context, LinearLayout linearLayout) {
        this.context = context;
        this.linearLayout=linearLayout;
        id[0] = R.id.now_tab;
        id[1] = R.id.upcoming_tab;






            tab[0]=(TextView) linearLayout.getChildAt(0);
            tab[1]=(TextView) linearLayout.getChildAt(1);




    }


    public void RoundedTabHelperListener(RoundedTabLayoutListener roundedTabLayoutListener) {
        this.roundedTabLayoutListener = roundedTabLayoutListener;

      tab[0].setOnClickListener(this);
        tab[1].setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Log.v("click","ok");
        //new two view code

        switch (view.getId())
        {
            case R.id.now_tab:
               if(old_place!=0) {
                   tab[0].setBackgroundResource(R.drawable.tab_rounded);
                   tab[0].setTextColor(Color.WHITE);
                   tab[1].setTextColor(Color.BLACK);
                   tab[1].setBackgroundResource(R.drawable.tab_rounded_unselect);
                   roundedTabLayoutListener.onClick(1);
                   Log.i("tab 1", "work");
               }
               old_place=0;
                break;
            case R.id.upcoming_tab:

                if(old_place!=1) {
                    tab[1].setBackgroundResource(R.drawable.tab_rounded);
                    tab[1].setTextColor(Color.WHITE);
                    tab[0].setTextColor(Color.BLACK);
                    tab[0].setBackgroundResource(R.drawable.tab_rounded_unselect);
                    Log.i("tab 2", "work");
                    roundedTabLayoutListener.onClick(2);
                }
                old_place=1;

        }


        //old bottom 3 view code
       /* for (int i = 0; i < id.length; i++) {
            if (view.getId() == id[i]) {
               if(old_place!=i) {

                   barview[i].setAnimation(null);
                   tarnslate = new TranslateAnimation(-400, 0, 0, 0);
                   tarnslate.setDuration(180);
                   barview[i].setVisibility(View.VISIBLE);
                   barview[i].setAnimation(tarnslate);
                   roundedTabLayoutListener.onClick(i);
                   imageView[i].setImageResource(AppConstants.BottomTabLayout.SELECT_GROUP[i]);
               }old_place=i;
            }
            else
            {
             barview[i].setVisibility(View.INVISIBLE);
                imageView[i].setImageResource(AppConstants.BottomTabLayout.UNSELECT_GROUP[i]);
            }


        }*/

    }


   public interface RoundedTabLayoutListener {
        void onClick(int i);

    }
}