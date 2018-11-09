package com.example.zay_phyo.movieme.Persistance.DbModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;

import com.example.zay_phyo.movieme.Persistance.ListConvetor;

import java.util.List;
@Entity(tableName = "movie_store")

public class DbTob {




    @ColumnInfo
    private List<offline_result> offline_results_db;

    @PrimaryKey(autoGenerate = true)
    public int id;



    public List<offline_result> getOffline_results_db() {
        return offline_results_db;
    }

    public void setOffline_results_db(List<offline_result> offline_results_db) {
        this.offline_results_db = offline_results_db;
    }
}
