package com.example.news.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface NewsDatabaseDao {
    @Insert
    void insertNews(News news);
    @Update
    void updateNews(News news);
    @Delete
    void deleteNews(News news);

    @Query("SELECT * FROM News")
    LiveData<List<News>> getAllNews();

    @Query("SELECT * FROM News WHERE inFavorite = 1")
    LiveData<List<News>> getFavoriteNews();
}
