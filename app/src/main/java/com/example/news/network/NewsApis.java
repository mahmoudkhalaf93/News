package com.example.news.network;

import com.example.news.network.response.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;


public interface NewsApis {

    @GET("top-headlines?country=eg&apiKey=fa72aea7f1af46a6a45be8aa23e21b64")
    Single<NewsResponse> getTopBannerNews();

    @GET("top-headlines?apiKey=1933e094f8ac49b4b17dfae255cd75c8&sources=bbc-news")
    Single<NewsResponse> getLatestNews();
}
