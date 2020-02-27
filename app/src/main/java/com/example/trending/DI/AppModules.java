package com.example.trending.DI;

import android.app.Application;
import android.content.Context;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;


@Module
public  abstract class AppModules {


    //Binds注解：告诉返回的Context是用参数里的Application实现的，只要在
    //Application构造函数添加inject注解即可，无需再添加依赖
    @Binds
    abstract Context bindContext(Application application);

}
