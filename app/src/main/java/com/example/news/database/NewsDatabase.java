package com.example.news.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;


@Database(entities = {NewsEgypt.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class NewsDatabase extends RoomDatabase {


    private static NewsDatabase database;

    public static NewsDatabase getInstance(Context context) {

        synchronized (context.getApplicationContext()) {
            if (database == null) {
                database = Room.databaseBuilder(context.getApplicationContext(), NewsDatabase.class, "news").
                        fallbackToDestructiveMigration().allowMainThreadQueries()
                        .build();
            }
            return database;
        }
    }

    public abstract NewsDatabaseDao getDao();


}
