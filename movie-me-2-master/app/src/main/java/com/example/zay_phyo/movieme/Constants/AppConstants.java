package com.example.zay_phyo.movieme.Constants;

import com.example.zay_phyo.movieme.R;

public class AppConstants {
    public static final String BASE_URL = "https://api.themoviedb.org/3/";
    public static final String MY_API = "bf1cf4db88befb3e52de4d16dd3c2e10";
    public static final int FIRST_PAGE = 0;
    public static final String GLIDE_IMAGE_URL = "http://image.tmdb.org/t/p/w185//";
    public static final String MOVIE_ID="moive_id";
    public static final int MOVIE_DATABASE_VERSION=33;
    public static final boolean ONLINE_MODE=true;
    public static final boolean OFFLINE_MODE=false;


    public static class BottomTabLayout {
        public static final int BAR_VIEW = R.id.now_view;
        public static final int BAR_VIEW1 = R.id.now_view1;
        public static final int BAR_VIEW2 = R.id.now_view2;






    }

    public static class TopRatedMovieApi {

        public static final String TOP_RATED_MOVIE_URI = "movie/top_rated";

    }

    public static class NowPlayingApi {
        public static final String NOW_PLAYING_MOVIE_API = "movie/now_playing";

    }

    public static class PopularMovieApi {
        public static final String POPULAR_MOVIE_API="movie/popular";

    }
    public static class DetailMoiveApi
    {
        public static final String DETAIL_MOIVE_API="/movie/{movie_id}/";
    }
    public static class UpcomingMovieApi {

        public static final String UPCOMING_MOVIE_API="movie/upcoming";

    }
}
