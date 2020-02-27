package com.example.trending;

import android.app.Application;
import android.content.Context;

import com.example.trending.DI.AppComponent;
import com.example.trending.DI.DaggerAppComponent;
import com.facebook.drawee.backends.pipeline.Fresco;

import dagger.android.AndroidInjector;
import dagger.android.DaggerApplication;
import io.reactivex.Scheduler;

public class App  extends DaggerApplication {

    private  static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        Fresco.initialize(this);
    }

    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        return DaggerAppComponent.builder().application(this).build();
    }

    public static Context getContext(){
        return mContext;
    }
}
