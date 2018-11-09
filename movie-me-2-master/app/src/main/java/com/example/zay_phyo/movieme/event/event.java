package com.example.zay_phyo.movieme.event;

import android.util.Log;

import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.ArrayList;
import java.util.List;

public class event {

    private MovieConvector movieConvector;
    private List<MovieResult>movieResults;
    private boolean success = false;

    public event() {

    }

    public event(MovieConvector movieConvector, boolean success) {
        this.movieConvector = movieConvector;
        this.success = success;
    }

    public event(List<MovieResult> movieResults, boolean success) {
        this.movieResults=new ArrayList<>();
        this.movieResults = movieResults;
        this.success = success;
    }

    public void setMovieConvector(MovieConvector movieConvector) {
        this.movieConvector = movieConvector;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public MovieConvector getMovieConvector() {
        return movieConvector;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setMovieResults(List<MovieResult> movieResults) {
        this.movieResults = movieResults;
    }

    public List<MovieResult> getMovieResults() {
        return movieResults;
    }

    public static class PopularResponseEvent extends event {

        public PopularResponseEvent() {
        }

        public PopularResponseEvent(MovieConvector movieConvector, boolean success) {

            super(movieConvector, success);
        }


    }

    public static class NowPlayingResponseEvent extends event {
        public NowPlayingResponseEvent() {
            super();
        }

        public NowPlayingResponseEvent(MovieConvector movieConvector, boolean success) {
            super(movieConvector, success);
        }
    }


    public static class TopRatedMovieResponse extends event
    {
        public TopRatedMovieResponse() {
          super();
        }

    }

    public static class UpComingMovieResponse extends  event {

        public UpComingMovieResponse() {
            super();
        }

        public UpComingMovieResponse(MovieConvector movieConvector, boolean success) {
            super(movieConvector, success);
        }
    }

}
