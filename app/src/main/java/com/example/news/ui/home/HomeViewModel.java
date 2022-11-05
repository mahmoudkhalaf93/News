package com.example.news.ui.home;


import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.news.database.NewsDatabaseDao;
import com.example.news.database.NewsEgypt;
import com.example.news.maper.Maper;
import com.example.news.network.NewsApis;
import com.example.news.network.response.NewsResponse;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class HomeViewModel extends AndroidViewModel {
    //    public HomeViewModel(@NonNull Application application) {
//        super(application);
//    }
    Application application;
    NewsApis newsApis;
    NewsDatabaseDao newsDatabaseDao;
    LiveData<List<NewsEgypt>> newsEgyptLiveData;
    MutableLiveData<List<NewsEgypt>> listofNewsEgypt=new MutableLiveData<>();

    public HomeViewModel(@NonNull Application application, NewsApis newsApis, NewsDatabaseDao newsDatabaseDao) {
        super(application);
        this.application = application;
        this.newsApis = newsApis;
        this.newsDatabaseDao = newsDatabaseDao;
        newsEgyptLiveData = newsDatabaseDao.getAllNewsEgypt();

        newsApis.getTopBannerNews().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new SingleObserver<NewsResponse>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onSuccess(NewsResponse newsResponse) {
               List<NewsEgypt> newsEgypts = new ArrayList<>();
                newsResponse.getArticles().forEach(article -> {
                    newsEgypts.add(Maper.maperFromNewsResponsToNewsEgyptDB(article));
                });
                listofNewsEgypt.setValue(newsEgypts);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void addNewsEgyptToFavorite(NewsEgypt newsEgypt) {
//        if (newsEgypt.getInFavorite()) {
//            newsEgypt.setInFavorite(false);
//            newsDatabaseDao.updateNewsEgypt(newsEgypt);
//        } else {
//            newsEgypt.setInFavorite(true);
//            newsDatabaseDao.updateNewsEgypt(newsEgypt);
//        }

    }
}