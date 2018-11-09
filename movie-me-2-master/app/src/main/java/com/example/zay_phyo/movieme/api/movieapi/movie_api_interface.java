package com.example.zay_phyo.movieme.api.movieapi;

import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.data.DetailConvector;
import com.example.zay_phyo.movieme.data.MovieConvector;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface movie_api_interface {

    @GET(AppConstants.TopRatedMovieApi.TOP_RATED_MOVIE_URI)
    Call<MovieConvector>get_movie_convector(@Query("api_key")String api);

    @GET(AppConstants.NowPlayingApi.NOW_PLAYING_MOVIE_API)
    Call<MovieConvector>get_movie_convector_now_playing(@Query("api_key")String api);

    @GET(AppConstants.PopularMovieApi.POPULAR_MOVIE_API)
    Call<MovieConvector>get_popular_movie(@Query("api_key")String api);

    @GET("movie/{movie_id}")
    Call<DetailConvector>get_detail_movie(@Path("movie_id")String id,@Query("api_key")String api);

    @GET(AppConstants.UpcomingMovieApi.UPCOMING_MOVIE_API)
    Call<MovieConvector>get_upcoming_movie(@Query("api_key")String api);
}
