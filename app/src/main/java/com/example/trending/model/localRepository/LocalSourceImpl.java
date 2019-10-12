package com.example.trending.model.localRepository;

import com.example.trending.App;
import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Maybe;

public class LocalSourceImpl implements LocalSource{

    private MyRoomDatabase database;
    public LocalSourceImpl(){
        database=MyRoomDatabase.getInstance(App.getContext());
    }


    @Override
    public Maybe<List<TrendBody>> getAllTrend() {
        return database.getTrendDao().getAllTrend();
    }

    @Override
    public Maybe<List<Long>> saveTrends(List<TrendBody> list) {
        new Thread(()-> database.getTrendDao().deleteAll()).start();
        return database.getTrendDao().saveTrends(list);
    }
}
