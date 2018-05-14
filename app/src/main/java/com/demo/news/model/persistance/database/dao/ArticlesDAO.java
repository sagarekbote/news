package com.demo.news.model.persistance.database.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.demo.news.model.Article;

import java.util.List;

@Dao
public interface ArticlesDAO {

    @Query("SELECT * From article")
    LiveData<List<Article>> getAllArticles();

    @Insert
    void insertAllArticles(List<Article> articleList);

    @Query("DELETE FROM article")
    void deleteAllArticles();
}
