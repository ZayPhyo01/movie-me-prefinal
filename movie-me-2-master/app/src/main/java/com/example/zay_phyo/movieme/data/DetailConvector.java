package com.example.zay_phyo.movieme.data;

import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailConvector {


    private String budget;

    private String vote_average;

    private String backdrop_path;

    @SerializedName("homepage")
    private String homepage;

    private String status;

    private String runtime;

    private String adult;

    private String id;

    private String title;

    private String original_language;

    private String overview;

    private List<ProductionCompany> production_companies;

    private String imdb_id;

    private String release_date;

    private String original_title;

    private String vote_count;

    private String poster_path;

    private String video;

    private String tagline;

    private String revenue;

    private String popularity;

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


    public String getId ()
    {
        return id;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTagline() {
        return tagline;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    public String getTitle ()
    {
        return title;
    }

    public void setTitle (String title)
    {
        this.title = title;
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

    public String getVote_count ()
    {
        return vote_count;
    }

    public void setVote_count (String vote_count)
    {
        this.vote_count = vote_count;
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

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }


}
