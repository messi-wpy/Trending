package com.example.trending;

import android.app.Application;
import android.content.Context;

import com.facebook.drawee.backends.pipeline.Fresco;

public class App  extends Application {

    private  static Context mContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mContext=getApplicationContext();
        Fresco.initialize(this);
    }
    public static Context getContext(){
        return mContext;
    }
}
