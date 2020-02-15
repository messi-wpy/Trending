package com.example.trending.presenter;

import android.util.Log;

import com.example.trending.TrendingContract;
import com.example.trending.model.DataSource;
import com.example.trending.model.TrendBody;
import com.example.trending.model.localRepository.LocalSource;
import com.example.trending.model.localRepository.LocalSourceImpl;
import com.example.trending.model.remoteRepository.RemoteSource;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableContainer;
import io.reactivex.internal.disposables.ListCompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class TrendingPresenter implements TrendingContract.Presenter {



    private DataSource dataSource;
    private TrendingContract.View view;
    private ListCompositeDisposable container;

    public TrendingPresenter(TrendingContract.View view){
        dataSource=new DataSource();
        this.view=view;
        container=new ListCompositeDisposable();
    }

    @Override
    public void loadTrending() {
        view.showLoadingView();
        Disposable d= dataSource.getTrends(false)
                .subscribeOn(Schedulers.io())
                .onErrorResumeNext(throwable -> {
                    Log.i("presenter", "loadTrending: ");
                    return dataSource.getFromLocal();
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        list -> {
                            if (list.size() == 0) {
                                view.showEmptyView();
                                return;
                            }
                            view.showTrending(list);
                            dataSource.savetoCache(list);
                            dataSource.savetoLocal(list);
                        }

                        ,throwable -> {
                        throwable.printStackTrace();
                        view.showErrorView();
                        }

                        ,()->{}

                );
        container.add(d);

    }

    @Override
    public void loadTrendingDetails() {

    }

    @Override
    public void destroy() {
        container.dispose();
        view=null;
    }
}
