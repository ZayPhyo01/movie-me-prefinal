package com.example.zay_phyo.movieme.mvp.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Model for both server and local

public class MovieResult extends BaseModel {




    public String vote_average;

    public String release_date;

    public String original_title;

    public String vote_count;

    public String poster_path;

    public String popularity;



    public String getVote_average() {
        return vote_average;
    }


    public String getRelease_date() {
        return release_date;
    }


    public String getOriginal_title() {
        return original_title;
    }


    public String getVote_count() {
        return vote_count;
    }


    public String getPoster_path() {
        return poster_path;
    }


    public String getPopularity() {
        return popularity;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public void setVote_count(String vote_count) {
        this.vote_count = vote_count;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }


}
