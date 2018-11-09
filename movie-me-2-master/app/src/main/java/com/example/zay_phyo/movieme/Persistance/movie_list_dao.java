package com.example.zay_phyo.movieme.Persistance;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.zay_phyo.movieme.Persistance.DbModel.DbNowPlaying;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbPopular;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.Detail;

@Dao
public interface movie_list_dao {
    @Query("Select * from movie_store")
    DbTob getOfflineTopMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTopMoive(DbTob dbConvetor);

    @Query("Delete from movie_store")
    void deleteToMovie();



    @Query("Select * from nowPlaying")
    DbNowPlaying getOfflineNowMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertNowMoive(DbNowPlaying nowPlaying);

    @Query("Delete from nowPlaying")
    void deleteNowMovie();



    @Query("Select * from popular")
    DbPopular getOfflinePopularMovie();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPopularMovie(DbPopular dbPopular);

    @Query("Delete from popular")
    void deletePopularMovie();


    @Query("Select * from detail_movie_table where id =:id")
    Detail getDetailMovie(int id);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDetailMovie(Detail detail);


    @Query("Delete from detail_movie_table")
    void deleteDetailMovie();

    @Query("Select id from detail_movie_table where id =:ids ")
    int getDetailId(int ids);




}
