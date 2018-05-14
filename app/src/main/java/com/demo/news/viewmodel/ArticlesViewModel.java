package com.demo.news.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.demo.news.NewsApplication;
import com.demo.news.di.component.ApplicationComponent;
import com.demo.news.model.Article;
import com.demo.news.model.repository.NewsRepository;

import java.util.List;

import javax.inject.Inject;

/**
 * A view model for the NewsActivity
 */
public class ArticlesViewModel extends AndroidViewModel {

    private LiveData<List<Article>> mArticleList;
    @Inject
    NewsRepository mNewsRepository;

    public ArticlesViewModel(@NonNull Application application) {
        super(application);
        ApplicationComponent component = ((NewsApplication) application).getComponent();
        component.inject(this);
    }

    public LiveData<List<Article>> getArticles() {
        if (mArticleList == null) {
            mArticleList = mNewsRepository.getArticles();
        }
        return mArticleList;
    }
}
