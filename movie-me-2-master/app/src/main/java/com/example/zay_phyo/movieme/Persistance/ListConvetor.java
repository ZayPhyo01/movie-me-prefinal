package com.example.zay_phyo.movieme.Persistance;

import android.arch.persistence.room.TypeConverter;

import com.example.zay_phyo.movieme.Persistance.DbModel.offline_result;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;


public class ListConvetor {



    @TypeConverter
    public static List<offline_result> toList(String json)
    {
        Gson gson=new Gson();
        Type type=new TypeToken<List<offline_result>>(){}.getType();
        return gson.fromJson(json,type);

    }
    @TypeConverter
    public static String toString(List<offline_result> offline_top)
    {
        Gson gson=new Gson();

        return gson.toJson(offline_top);
    }
}
