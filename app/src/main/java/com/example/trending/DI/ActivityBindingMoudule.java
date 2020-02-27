package com.example.trending.DI;


import com.example.trending.view.MainActivity;
import com.example.trending.viewmodel.TrendingListModule;
import com.example.trending.viewmodel.TrendingViewModel;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBindingMoudule {

    //让TrendingViewModel与activity绑定

    @ActivityScoped
    @ContributesAndroidInjector(modules = TrendingListModule.class)
    abstract MainActivity MainActivity();
}
