package com.example.zay_phyo.movieme.Persistance.DbModel;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "detail_movie_table")
public class Detail {



    @ColumnInfo
    private String vote_average;

    @ColumnInfo
    private String homepage;

    @ColumnInfo
    private String runtime;

    @PrimaryKey
    private int id;

    @ColumnInfo
    private String original_language;

    @ColumnInfo
    private String overview;

    @ColumnInfo
    private List<ProductionCompany> production_companies;

    @ColumnInfo
    private String release_date;

    @ColumnInfo
    private String original_title;

    @ColumnInfo
    private String poster_path;

    @ColumnInfo
    private String tagline;

    @ColumnInfo
    private String title;

    public String getVote_average ()
    {
        return vote_average;
    }

    public void setVote_average (String vote_average)
    {
        this.vote_average = vote_average;
    }

    public String getRuntime ()
    {
        return runtime;
    }

    public void setRuntime (String runtime)
    {
        this.runtime = runtime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTagline() {
        return tagline;
    }

    public String getOriginal_language ()
    {
        return original_language;
    }

    public void setOriginal_language (String original_language)
    {
        this.original_language = original_language;
    }

    public String getOverview ()
    {
        return overview;
    }

    public void setOverview (String overview)
    {
        this.overview = overview;
    }


    public List<ProductionCompany> getProduction_companies() {
        return production_companies;
    }

    public void setProduction_companies(List<ProductionCompany> production_companies) {
        this.production_companies = production_companies;
    }

    public String getRelease_date ()
    {
        return release_date;
    }

    public void setRelease_date (String release_date)
    {
        this.release_date = release_date;
    }

    public String getOriginal_title ()
    {
        return original_title;
    }

    public void setOriginal_title (String original_title)
    {
        this.original_title = original_title;
    }



    public String getPoster_path ()
    {
        return poster_path;
    }

    public void setPoster_path (String poster_path)
    {
        this.poster_path = poster_path;
    }

    public String getHomepage() {
        return homepage;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
