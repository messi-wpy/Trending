package com.example.trending.model;

import com.example.trending.TrendingContract;
import com.example.trending.model.localRepository.LocalSource;
import com.example.trending.model.localRepository.LocalSourceImpl;
import com.example.trending.model.remoteRepository.RemoteSource;

import java.util.List;

import io.reactivex.Observable;

public class DataSource {

    private RemoteSource remote;
    private LocalSource local;


    private List<TrendBody>cacheTrend;
    private long lastUpdateTime= 0L;

    public DataSource(){
        remote=new RemoteSource();
        local=new LocalSourceImpl();
    }

    public boolean isDirty(){
        long now=System.currentTimeMillis();
        return now-lastUpdateTime<=7200*1000;

    }
    public boolean hasCache(){
        if (cacheTrend==null)
            return false;
        else
            return true;
    }


    public Observable<List<TrendBody>>getTrends(boolean forceUpdate){
        if (isDirty()||!hasCache()||forceUpdate){
            lastUpdateTime=System.currentTimeMillis();
            return remote.getTrendings();
        }else
            return Observable.create(emitter -> {
                emitter.onNext(cacheTrend);
            });
    }

    public void savetoCache(List<TrendBody>list){
        cacheTrend=list;
    }
    public void savetoLocal(List<TrendBody>list){
        local.saveTrends(list);
    }

    public Observable<List<TrendBody>> getFromLocal(){
        return local.getAllTrend().toObservable();
    }


}
