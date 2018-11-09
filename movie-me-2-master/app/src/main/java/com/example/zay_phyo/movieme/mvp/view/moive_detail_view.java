package com.example.zay_phyo.movieme.mvp.view;

import com.example.zay_phyo.movieme.mvp.model.ProductionCompany;

import java.util.List;

public interface moive_detail_view {

 void detail_imgae_url(String url);
 void detail_title(String title);
 void detail_time(String time);
 void detail_date(String date);
 void detail_homepage(String url);//More button use
 void detail_overview(String overview);
 void detail_company(List<ProductionCompany>productionCompanyList);
 void detail_fail();
 void detail_tag_line(String tagline);
 void detail_rate(String rate);

}
