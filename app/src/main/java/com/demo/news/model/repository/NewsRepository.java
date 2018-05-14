package com.demo.news.model.repository;

import android.arch.lifecycle.LiveData;
import android.content.Context;

import com.demo.news.NewsApplication;
import com.demo.news.di.component.ApplicationComponent;
import com.demo.news.model.Article;
import com.demo.news.model.TopStoriesResponse;
import com.demo.news.model.network.NewsAPIConfig;
import com.demo.news.model.network.NewsService;
import com.demo.news.model.persistance.database.ArticlesDatabaseHelper;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;
import timber.log.Timber;

/**
 * A repository class that will either make a network call or make a database call to get data.
 */
public class NewsRepository {

    @Inject
    NewsService mNewsService;
    @Inject
    ArticlesDatabaseHelper mArticlesDbHelper;

    public NewsRepository(Context context) {
        ApplicationComponent component = ((NewsApplication) context.getApplicationContext()).getComponent();
        component.inject(this);
    }

    public LiveData<List<Article>> getArticles() {

        mNewsService.getTopStories(NewsAPIConfig.API_KEY).doOnNext(new Action1<Response<TopStoriesResponse>>() {
            @Override
            public void call(Response<TopStoriesResponse> topStoriesResponseResponse) {
                if (topStoriesResponseResponse.isSuccessful()) {
                    Timber.d("inserting new data in db");
                    mArticlesDbHelper.deleteAllArticles();
                    mArticlesDbHelper.insertAllArticles(topStoriesResponseResponse.body().getResults());
                }
            }
        }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<Response<TopStoriesResponse>>() {
            @Override
            public void call(Response<TopStoriesResponse> topStoriesResponseResponse) {
                Timber.d("Got the api response in News repository" + topStoriesResponseResponse.isSuccessful());
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                Timber.d("Exception in news repository" + throwable.getMessage());
            }
        });
        return mArticlesDbHelper.getAllArticles();
    }
}
