package com.example.zay_phyo.movieme.mvp.view;

import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.List;

public interface movie_upcoming_ivew {

    void success(List<MovieResult>movieResults);
    void fail();


}
