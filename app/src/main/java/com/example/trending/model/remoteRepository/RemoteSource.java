package com.example.trending.model.remoteRepository;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class RemoteSource  {

    public Observable<List<TrendBody>> getTrendings(){
        return RetrofitFactory.getService().getTrend();
    }


}
