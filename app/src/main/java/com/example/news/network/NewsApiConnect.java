package com.example.news.network;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NewsApiConnect {
    private static NewsApis newsApis; // interface

    public static NewsApis getInstance(){

        if(newsApis==null){

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://newsapi.org/v2/")
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            newsApis = retrofit.create(NewsApis.class);}
        return newsApis;
    }

}
