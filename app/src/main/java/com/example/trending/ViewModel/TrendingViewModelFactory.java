package com.example.trending.ViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.trending.model.DataSource;

public class TrendingViewModelFactory implements ViewModelProvider.Factory {

    private DataSource mDataSource;
    public TrendingViewModelFactory(DataSource dataSource){

        this.mDataSource=dataSource;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TrendingViewModel.class)){
            return (T) new TrendingViewModel(mDataSource);
        }else {
            throw new IllegalArgumentException("ViewModel Not Found");
        }

    }
}
