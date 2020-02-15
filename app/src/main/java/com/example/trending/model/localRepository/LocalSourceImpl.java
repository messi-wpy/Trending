package com.example.trending.model.localRepository;

import com.example.trending.App;
import com.example.trending.model.TrendBody;

import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Action;
import io.reactivex.functions.Function;

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
    public Completable saveTrends(List<TrendBody> list) {
        return Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                database.getTrendDao().deleteAll();
                database.getTrendDao().saveTrends(list);
            }
        });
    }
}
