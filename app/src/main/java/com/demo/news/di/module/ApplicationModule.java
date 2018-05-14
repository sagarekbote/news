package com.demo.news.di.module;

import android.app.Application;
import android.content.Context;

import com.demo.news.model.network.NewsAPIConfig;
import com.demo.news.model.network.NewsService;
import com.demo.news.model.persistance.database.ArticlesDatabaseHelper;
import com.demo.news.model.repository.NewsRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    private Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofitObject() {
        return new Retrofit.Builder().baseUrl(NewsAPIConfig.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(providesHttpClient())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    public OkHttpClient providesHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return new OkHttpClient().newBuilder().addInterceptor(interceptor).build();
    }

    @Provides
    public NewsService providesNewsService(Retrofit retrofit) {
        return retrofit.create(NewsService.class);
    }

    @Provides
    @Singleton
    public NewsRepository providesNewsRepository(Context context) {
        return new NewsRepository(context);
    }

    @Provides
    @Singleton
    public ArticlesDatabaseHelper articlesDatabaseHelper(Context context) {
        return new ArticlesDatabaseHelper(context);
    }
}
