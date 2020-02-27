package com.example.trending.model;

import android.util.Log;

import com.example.trending.TrendingContract;
import com.example.trending.model.localRepository.LocalSource;
import com.example.trending.model.localRepository.LocalSourceImpl;
import com.example.trending.model.remoteRepository.RemoteSource;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.schedulers.Schedulers;

public class DataSource {

    private RemoteSource remote;
    private LocalSource local;

    private final String TAG="DataSource";



    @Inject
    public DataSource(RemoteSource remote,LocalSource local){
        this.remote=remote;
        this.local=local;

    }



    public Observable<List<TrendBody>>getTrends(boolean forceUpdate){
        if (forceUpdate){
            return getTrendsFromeRemote();
        }
        return remote.getTrendings()
                .onErrorResumeNext(throwable -> {
                        return getFromLocal();
                })
                .subscribeOn(Schedulers.io());

    }

    public Observable<List<TrendBody>>getTrendsFromeRemote(){
        return remote.getTrendings();

    }
    public void savetoLocal(List<TrendBody>list){

        local.saveTrends(list).subscribe();
    }

    public Observable<List<TrendBody>> getFromLocal(){
        return local.getAllTrend().toObservable();
    }


}
