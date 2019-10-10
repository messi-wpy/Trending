package com.example.trending.model.remoteRepository;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

public class RetrofitFactory {
    private static volatile RetrofitService service;

    public static RetrofitService getService(){
        if (service==null){
            synchronized (RetrofitFactory.class){
                if (service==null){
                    service= new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl("https://github-trending-api.now.sh/")
                            .build()
                            .create(RetrofitService.class);

                }

            }
            return service;

        }
        return service;

    }


    public interface RetrofitService{

        @GET("repositories?language=&since=daily")
        Observable<List<TrendBody>>getTrend();
    }
}
