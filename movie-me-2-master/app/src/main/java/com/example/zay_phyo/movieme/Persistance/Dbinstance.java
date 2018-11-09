package com.example.zay_phyo.movieme.Persistance;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;


import com.example.zay_phyo.movieme.Constants.AppConstants;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbNowPlaying;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbPopular;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.DbUpcoming;
import com.example.zay_phyo.movieme.Persistance.DbModel.Detail;
import com.example.zay_phyo.movieme.Repository.Repository;


@Database(entities = {DbTob.class,DbPopular.class,DbNowPlaying.class,Detail.class,DbUpcoming.class},version = AppConstants.DB_VERSION)
@TypeConverters({ListConvetor.class,CompanyConvetor.class})
public abstract class Dbinstance extends RoomDatabase {


        private static final String DB_NAME = AppConstants.DBNAME;
        private static volatile Dbinstance instance;

        public   static synchronized Dbinstance getInstance(Context context) {
            if (instance == null) {
                instance = create(context);
            }
            return instance;
        }

        private static Dbinstance create(final Context context) {
            return Room.databaseBuilder(
                    context,
                    Dbinstance.class,
                    DB_NAME).addCallback(new Callback() {
                @Override
                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                    Repository.DbPopularMovie.insertData(new DbPopular());
                    Repository.DbNowMovie.insertData(new DbNowPlaying());
                    Repository.DbTopMovie.insertData(new DbTob());
                    super.onCreate(db);
                }
            }) .build();
        }

        public abstract movie_list_dao getMoivedao();



    }







