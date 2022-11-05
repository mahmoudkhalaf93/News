package com.example.news.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Single;

@Dao
public interface NewsDatabaseDao {
//    @Insert
//    Single<Void> insertNews(News news);
//    @Update
//    Single<Void> updateNews(News news);
//    @Delete
//    Single<Void> deleteNews(News news);
//
//    @Query("SELECT * FROM News")
//    LiveData<List<News>> getAllNews();
//
//    @Query("SELECT * FROM News WHERE inFavorite = 1")
//    LiveData<List<News>> getFavoriteNews();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Void insertNewsEgypt(NewsEgypt newsEgypt);
    @Update
    Void updateNewsEgypt(NewsEgypt newsEgypt);
    @Delete
    Void deleteNewsEgypt(NewsEgypt newsEgypt);

    @Query("SELECT * FROM NewsEgypt")
    LiveData<List<NewsEgypt>> getAllNewsEgypt();

    @Query("SELECT * FROM NewsEgypt WHERE inFavorite = 1")
    LiveData<List<NewsEgypt>> getFavoriteNewsEgypt();

}
