package com.example.trending.DI;

import android.app.Application;

import com.example.trending.App;
import com.example.trending.databinding.ActivityMainBinding;
import com.example.trending.model.DataSourceModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        DataSourceModule.class,
        AppModules.class,
        ActivityBindingMoudule.class
})
public interface AppComponent extends AndroidInjector<App> {


    //自定义其Builder构造方法
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }


}
