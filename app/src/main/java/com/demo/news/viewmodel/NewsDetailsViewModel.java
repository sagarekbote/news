package com.demo.news.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.demo.news.model.Article;
/**
 * A view model for the details activity
 */
public class NewsDetailsViewModel extends AndroidViewModel {

    private LiveData<Article> mArticle;

    public NewsDetailsViewModel(@NonNull Application application) {
        super(application);
    }

    public void setArticle(Article article) {
        final MutableLiveData<Article> articleMutableLiveData = new MutableLiveData<>();
        articleMutableLiveData.setValue(article);
        mArticle = articleMutableLiveData;
    }

    public LiveData<Article> getArticleList() {
        return mArticle;
    }
}
