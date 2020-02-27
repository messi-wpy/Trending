package com.example.trending.model;


import android.content.Context;

import com.example.trending.model.localRepository.LocalSource;
import com.example.trending.model.localRepository.LocalSourceImpl;
import com.example.trending.model.remoteRepository.RemoteSource;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

@Module
public class DataSourceModule {


    @Provides
    @Singleton
    public Retrofit providerRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
        return new Retrofit.Builder()
                .client(okHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://github-trending-api.now.sh/")
                .build();
    }

    @Provides
    @Singleton
    RemoteSource provideRemoteTrendingSource(Retrofit retrofit){
        return new RemoteSource(retrofit);
    }

    @Singleton
    @Provides
    LocalSource provideLocalSource(Context context){
        return new LocalSourceImpl(context);
    }
}
