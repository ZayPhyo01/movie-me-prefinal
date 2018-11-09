package com.example.zay_phyo.movieme.Persistance.DbModel;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "upcoming_movie")
public class DbUpcoming {

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
