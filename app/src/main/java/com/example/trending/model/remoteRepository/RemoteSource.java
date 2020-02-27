package com.example.trending.model.remoteRepository;

import com.example.trending.model.TrendBody;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public class RemoteSource  {

    private RetrofitService service;
    public RemoteSource(Retrofit retrofit){
        this.service=retrofit.create(RetrofitService.class);
    }
    public Observable<List<TrendBody>> getTrendings(){
        return service.getTrend() ;
    }


    public interface RetrofitService{

        @GET("repositories?language=&since=daily")
        Observable<List<TrendBody>>getTrend();
    }

}
