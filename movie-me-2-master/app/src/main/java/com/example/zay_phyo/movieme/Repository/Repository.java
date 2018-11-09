package com.example.zay_phyo.movieme.Repository;

import android.os.AsyncTask;
import android.util.Log;

import com.example.zay_phyo.movieme.App;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbNowPlaying;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbPopular;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbUpcoming;
import com.example.zay_phyo.movieme.Persistance.DbModel.Detail;
import com.example.zay_phyo.movieme.Persistance.DbModel.offline_result;
import com.example.zay_phyo.movieme.Persistance.ListHelper;
import com.example.zay_phyo.movieme.data.DetailConvector;
import com.example.zay_phyo.movieme.data.MovieConvector;
import com.example.zay_phyo.movieme.data.movie_response.DetailResponse;
import com.example.zay_phyo.movieme.event.detailevent;
import com.example.zay_phyo.movieme.event.event;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;
import com.example.zay_phyo.movieme.mvp.presenter.MovieDetailPresenter;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import static com.example.zay_phyo.movieme.App.getApp;

public class Repository {


    public static class DbTopMovie {

        public static void getData() {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    //   getApp().getDatabase().getMoivedao().deleteToMovie();
                    DbTob dbTob;
                    dbTob = App.getApp().getDatabase().getMoivedao().getOfflineTopMovie();
                    if (dbTob == null) {
                        dbTob = new DbTob();
                    }
                    List<offline_result> list;

                    list = dbTob.getOffline_results_db();
                    if (list == null) {
                        list = new ArrayList<>();
                    }

                    Log.i("Db query list size : ", list.size() + "");

                    List<MovieResult> movieResults = ListHelper.Offline_Online.convertToResult(list);

                    MovieConvector movieConvector = new MovieConvector();

                    movieConvector.setResults(movieResults);
                    event.TopRatedMovieResponse topRatedMovieResponse = new event.TopRatedMovieResponse();
                    topRatedMovieResponse.setSuccess(true);
                    topRatedMovieResponse.setMovieConvector(movieConvector);
                    EventBus.getDefault().post(topRatedMovieResponse);

                    return null;
                }
            }.execute();

        }

        public static void insertData(DbTob list) {

            new AsyncTask<DbTob, Void, Void>() {
                @Override
                protected Void doInBackground(DbTob... lists) {
                    App.getApp().getDatabase().getMoivedao().deleteToMovie();
                    App.getApp().getDatabase().getMoivedao().insertTopMoive(lists[0]);

                    //Log.i("Db ","Save"+i);
                    return null;
                }
            }.execute(list);


        }


    }

    public static class DbNowMovie {

        public static void insertData(DbNowPlaying list) {

            new AsyncTask<DbNowPlaying, Void, Void>() {
                @Override
                protected Void doInBackground(DbNowPlaying... list1) {
                    App.getApp().getDatabase().getMoivedao().deleteNowMovie();
                    App.getApp().getDatabase().getMoivedao().insertNowMoive(list1[0]);

                    //Log.i("Db ","Save"+i);
                    return null;
                }
            }.execute(list);


        }

        public static void getData() {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    ;

                    DbNowPlaying dbNowPlaying;
                    List<offline_result> list;
                    dbNowPlaying = new DbNowPlaying();
                    list = new ArrayList<>();

                    dbNowPlaying = App.getApp().getDatabase().getMoivedao().getOfflineNowMovie();

                    if (dbNowPlaying != null) {
                        list = dbNowPlaying.getOffline_results_db();
                    }

                    //                 //   Log.i("Db query list size : ",list.size()+"");

                    List<MovieResult> movieResults = ListHelper.Offline_Online.convertToResult(list);

                    MovieConvector movieConvector = new MovieConvector();

                    movieConvector.setResults(movieResults);
                    event.NowPlayingResponseEvent now = new event.NowPlayingResponseEvent();
                    now.setSuccess(true);
                    now.setMovieConvector(movieConvector);
                    EventBus.getDefault().post(now);

                    return null;
                }
            }.execute();

        }


    }

    public static class DbPopularMovie {


        public static void getData() {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    //   getApp().getDatabase().getMoivedao().deleteToMovie();
                    DbPopular dbPopular;

                    dbPopular = App.getApp().getDatabase().getMoivedao().getOfflinePopularMovie();

                    if (dbPopular == null) {
                        dbPopular = new DbPopular();
                    }

                    List<offline_result> list;

                    list = dbPopular.getOffline_results_db();
                    // Log.i("Db query list size : ",list.size()+"");
                    if (list == null) {
                        list = new ArrayList<>();
                    }

                    List<MovieResult> movieResults = ListHelper.Offline_Online.convertToResult(list);

                    MovieConvector movieConvector = new MovieConvector();

                    movieConvector.setResults(movieResults);
                    event.PopularResponseEvent popular = new event.PopularResponseEvent();
                    popular.setSuccess(true);
                    popular.setMovieConvector(movieConvector);
                    EventBus.getDefault().post(popular);

                    return null;
                }
            }.execute();

        }

        public static void insertData(DbPopular list) {

            new AsyncTask<DbPopular, Void, Void>() {
                @Override
                protected Void doInBackground(DbPopular... list1) {
                    App.getApp().getDatabase().getMoivedao().deletePopularMovie();
                    App.getApp().getDatabase().getMoivedao().insertPopularMovie(list1[0]);

                    //Log.i("Db ","Save"+i);
                    return null;
                }
            }.execute(list);


        }
    }

    public static class DetalMovieDb {

        public static void getData(int id) {

            new AsyncTask<Integer, Void, Void>() {
                @Override
                protected Void doInBackground(Integer... voids) {
                    //   getApp().getDatabase().getMoivedao().deleteToMovie();
                    Detail detail;

                    detail = App.getApp().getDatabase().getMoivedao().getDetailMovie(voids[0]);

                    if (detail == null) {
                        DetailResponse.getMoiveDetail(String.valueOf(voids[0]));
                    }else {

                        detailevent detailevent = new detailevent();
                        DetailConvector detailConvector = new DetailConvector();

                        detailConvector.setHomepage(detail.getHomepage());
                        detailConvector.setOriginal_language(detail.getOriginal_language());
                        detailConvector.setOriginal_title(detail.getOriginal_title());

                        detailConvector.setOverview(detail.getOverview());
                        detailConvector.setPoster_path(detail.getPoster_path());
                        detailConvector.setRelease_date(detail.getRelease_date());

                        detailConvector.setProduction_companies(detail.getProduction_companies());
                        detailConvector.setRuntime(detail.getRuntime());
                        detailConvector.setTitle(detail.getTitle());


                        detailConvector.setVote_average(detail.getVote_average());
                        detailConvector.setTagline(detail.getTagline());


                        detailevent.setDetailConvector(detailConvector);
                        Log.v("Query overview", detailConvector.getOverview());
                        detailevent.setSuccess(true);

                        EventBus.getDefault().post(detailevent);

                    }
                    return null;
                }
            }.execute(id);

        }

        public static void insertData(final Detail detail) {

            new AsyncTask<Detail, Void, Void>() {
                @Override
                protected Void doInBackground(Detail... details) {
                 //   App.getApp().getDatabase().getMoivedao().deleteDetailMovie();
                    App.getApp().getDatabase().getMoivedao().insertDetailMovie(details[0]);

                    //   Log.i("detail title",details[0].getTitle());
                    //    Log.i("date",details[0].getRelease_date());
                    Log.i("Db ", "Save");
                    return null;
                }
            }.execute(detail);


        }
        public static void delete()
        {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    App.getApp().getDatabase().getMoivedao().deleteDetailMovie();

                    return null;
                }
            }.execute();
        }


    }
    public static class UpcomingDb {

        public static void getData( ) {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                  DbUpcoming dbUpcoming;
                   dbUpcoming=   App.getApp().getDatabase().getMoivedao().getUpcomingMovie();

                    if (dbUpcoming == null) {
                        dbUpcoming = new DbUpcoming();
                    }
                    List<offline_result> list;

                    list = dbUpcoming.getOffline_results_db();
                    if (list == null) {
                        list = new ArrayList<>();
                    }

                    Log.i("Db query list size : ", list.size() + "");

                    List<MovieResult> movieResults = ListHelper.Offline_Online.convertToResult(list);

                    MovieConvector movieConvector=new MovieConvector();
                    movieConvector.setResults(movieResults);
                    event.UpComingMovieResponse event=new event.UpComingMovieResponse();
                    event.setSuccess(true);
                    event.setMovieConvector(movieConvector);

                    EventBus.getDefault().post(event);




                    return null;
                }
            }.execute();

        }

        public static void insertData(final DbUpcoming dbUpcoming) {

            new AsyncTask<DbUpcoming, Void, Void>() {
                @Override
                protected Void doInBackground(DbUpcoming... upcomings) {
                    //   App.getApp().getDatabase().getMoivedao().deleteDetailMovie();
                    App.getApp().getDatabase().getMoivedao().insertUpcomingMovie(upcomings[0]);

                    //   Log.i("detail title",details[0].getTitle());
                    //    Log.i("date",details[0].getRelease_date());
                    Log.i("Db ", "Save");
                    return null;
                }
            }.execute(dbUpcoming);


        }
        public static void delete()
        {

            new AsyncTask<Void, Void, Void>() {
                @Override
                protected Void doInBackground(Void... voids) {
                    App.getApp().getDatabase().getMoivedao().deleteUpcomingMovie();

                    return null;
                }
            }.execute();
        }


    }

}
