package com.demo.news;

import android.app.Application;
import android.content.Context;

import com.demo.news.di.component.ApplicationComponent;
import com.demo.news.di.component.DaggerApplicationComponent;
import com.demo.news.di.module.ApplicationModule;

public class NewsApplication extends Application  {

    protected ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static NewsApplication get(Context context) {
        return (NewsApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent(){
        return mApplicationComponent;
    }
}
