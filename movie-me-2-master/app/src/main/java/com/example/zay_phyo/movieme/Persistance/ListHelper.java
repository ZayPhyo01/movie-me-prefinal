package com.example.zay_phyo.movieme.Persistance;

import com.example.zay_phyo.movieme.Persistance.DbModel.DbTob;
import com.example.zay_phyo.movieme.Persistance.DbModel.offline_result;
import com.example.zay_phyo.movieme.mvp.model.MovieResult;

import java.util.ArrayList;
import java.util.List;

public class ListHelper {


public static class Online_Offline {

    public static  List<offline_result>convertToTop(List<MovieResult>movieResults) {
        List<offline_result>offline_results=new ArrayList<>();

        for(int i=0;i<movieResults.size();i++) {
                offline_result offline_result=new offline_result();
            offline_result.setPopularity_offline(movieResults.get(i).getPopularity());
            offline_result.setOriginal_title_offline(movieResults.get(i).getOriginal_title());
            offline_result.setRelease_date_offline(movieResults.get(i).getRelease_date());
            offline_result.setPoster_path_offline(movieResults.get(i).getPoster_path());
            offline_result.setVote_average_offline(movieResults.get(i).getVote_average());
            offline_result.setVote_count_offline(movieResults.get(i).getVote_count());
            offline_result.setMovie_id(movieResults.get(i).getId());
            offline_results.add(offline_result);

        }



        return (offline_results.size()!=0) ? offline_results : new ArrayList<offline_result>();
    }




}

    public static class Offline_Online {

    public static List<MovieResult>convertToResult(List<offline_result>offline_results) {
        List<MovieResult>movieResults=new ArrayList<>();
if(offline_results!=null)
        for(int i=0;i<offline_results.size();i++) {
            MovieResult movieResult=new MovieResult();
        movieResult.setOriginal_title(offline_results.get(i).getOriginal_title_offline());
        movieResult.setPopularity(offline_results.get(i).getPopularity_offline());
        movieResult.setPoster_path(offline_results.get(i).getPoster_path_offline());
        movieResult.setRelease_date(offline_results.get(i).getRelease_date_offline());
        movieResult.setVote_count(offline_results.get(i).getVote_count_offline());
        movieResult.setVote_average(offline_results.get(i).getVote_average_offline());
       movieResult.setId(offline_results.get(i).getMovie_id());

            movieResults.add(movieResult);


        }
        return (movieResults.size()!=0) ? movieResults : new ArrayList<MovieResult>();


    }



    }
}
