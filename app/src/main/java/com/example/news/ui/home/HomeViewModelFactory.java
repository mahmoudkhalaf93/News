package com.example.news.ui.home;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.news.database.NewsDatabaseDao;
import com.example.news.network.NewsApiConnect;
import com.example.news.network.NewsApis;

import javax.inject.Inject;

import kotlin.Suppress;

public class HomeViewModelFactory implements ViewModelProvider.Factory {
    Application application; NewsApis newsApis; NewsDatabaseDao newsDatabaseDao;


    public HomeViewModelFactory(Application application, NewsApis newsApis, NewsDatabaseDao newsDatabaseDao) {
        this.application = application;
        this.newsApis=newsApis;
        this.newsDatabaseDao = newsDatabaseDao;
    }

    @NonNull
    @Override

    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {

        if (modelClass.isAssignableFrom(HomeViewModel.class))
            return (T) new HomeViewModel(application,newsApis,newsDatabaseDao);

        throw new IllegalArgumentException("Unknown ViewModel class");
    }



}
