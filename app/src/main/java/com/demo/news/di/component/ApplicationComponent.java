package com.demo.news.di.component;

import com.demo.news.NewsApplication;
import com.demo.news.di.module.ApplicationModule;
import com.demo.news.model.persistance.database.ArticlesDatabaseHelper;
import com.demo.news.model.repository.NewsRepository;
import com.demo.news.viewmodel.ArticlesViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(NewsApplication target);

    void inject(NewsRepository target);

    void inject(ArticlesDatabaseHelper target);

    void inject(ArticlesViewModel target);
}
