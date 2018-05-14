package com.demo.news.model.persistance.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.demo.news.model.Article;
import com.demo.news.model.Multimedium;
import com.demo.news.model.persistance.database.dao.ArticlesDAO;

@Database(entities = Article.class, version = 1, exportSchema = false)
public abstract class NewsDatabase extends RoomDatabase {

    public static final String DATABASE = "news_database.db";
    private static NewsDatabase newsDatabase;

    public static NewsDatabase getInstance(Context context) {
        if (newsDatabase == null) {
            newsDatabase = Room.databaseBuilder(context, NewsDatabase.class, DATABASE).build();
        }
        return newsDatabase;
    }

    public abstract ArticlesDAO getArticlesDAO();
}
