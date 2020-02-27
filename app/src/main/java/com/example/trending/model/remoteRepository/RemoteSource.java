package com.example.trending.model.remoteRepository;

import com.example.trending.model.TrendBody;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RemoteSource  {

    @Inject
    private RetrofitFactory.RetrofitService service;
    public Observable<List<TrendBody>> getTrendings(){
        return service.getTrend() ;
    }


}
