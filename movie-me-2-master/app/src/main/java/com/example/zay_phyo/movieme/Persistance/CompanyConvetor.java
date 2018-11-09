package com.example.zay_phyo.movieme.Persistance;

import android.arch.persistence.room.TypeConverter;

import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class CompanyConvetor {

    @TypeConverter
    public static String toJson(List<ProductionCompany>companyList)
    {
        Gson gson=new Gson();
        return gson.toJson(companyList);

    }
    @TypeConverter
    public static List<ProductionCompany>toCompany(String json) {

        Gson gson=new Gson();
        Type type=new TypeToken<List<ProductionCompany>>(){}.getType();
        return gson.fromJson(json,type);

    }

}
