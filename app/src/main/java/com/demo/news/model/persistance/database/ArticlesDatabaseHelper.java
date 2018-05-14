package com.demo.news.model.persistance.database;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.demo.news.model.Article;
import com.demo.news.model.persistance.database.dao.ArticlesDAO;

import java.util.List;

import javax.inject.Inject;

/**
 * A Helper class for the Articles database
 */
public class ArticlesDatabaseHelper {

    private ArticlesDAO mArticlesDAO;

    @Inject
    public ArticlesDatabaseHelper(Context context) {
        NewsDatabase newsDatabase = NewsDatabase.getInstance(context);
        mArticlesDAO = newsDatabase.getArticlesDAO();
    }

    public LiveData<List<Article>> getAllArticles() {
        return mArticlesDAO.getAllArticles();
    }

    public void insertAllArticles(List<Article> articleList) {
        mArticlesDAO.insertAllArticles(articleList);
    }

    public void deleteAllArticles() {
        mArticlesDAO.deleteAllArticles();
    }
}
