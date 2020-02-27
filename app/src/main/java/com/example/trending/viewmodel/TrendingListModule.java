package com.example.trending.viewmodel;


import com.example.trending.model.DataSource;

import dagger.Module;
import dagger.Provides;

@Module
public class TrendingListModule {


    @Provides
    TrendingViewModelFactory provideFatory(DataSource dataSource){
        return new TrendingViewModelFactory(dataSource);
    }
}
