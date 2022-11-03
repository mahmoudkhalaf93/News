package com.example.news;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.example.news.database.News;
import com.example.news.database.NewsDatabase;
import com.example.news.database.NewsDatabaseDao;

import java.io.IOException;
import java.util.List;

import kotlin.jvm.Throws;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    private NewsDatabase database;
    NewsDatabaseDao dao;

    @Before
    public void creatDatabase(){
      Context context =  ApplicationProvider.getApplicationContext();
        database = Room.inMemoryDatabaseBuilder(context, NewsDatabase.class)
        // Allowing main thread queries, just for testing.
            .allowMainThreadQueries()
                .build();
        dao = database.getDao();
    }
    @After
    @Throws(exceptionClasses = IOException.class)
    public void closeDb(){
        database.close();
    }
    @Test
    public void useAppContext() {
        // Context of the app under test.
//        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
//        assertEquals("com.example.news", appContext.getPackageName());

        News news =new  News();
        news.setTitle("mahmoud");
        dao.insertNews(news);
        LiveData<List<News>> newsLiveData = dao.getAllNews();
        assertEquals(newsLiveData.getValue().get(0).getTitle() , "yass");
    }
}