package com.example.trending.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.trending.model.DataSource;
import com.example.trending.model.TrendBody;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class TrendingViewModel extends ViewModel {



    private MutableLiveData<List<TrendBody>> mTrendingLiveData=new MutableLiveData<>();
    private CompositeDisposable mDisposable = new CompositeDisposable();

    private DataSource mDataSource;
    private AtomicBoolean hasInited=new AtomicBoolean(false);
    private MutableLiveData<Boolean> mDataLoading = new MutableLiveData<>();
    private MutableLiveData<Boolean> mErrorState = new MutableLiveData<>();


    public TrendingViewModel(DataSource dataSource){
        mDataSource=dataSource;

    }



    public void initData(){
        //防止重新加载
        if (hasInited.get()){
            return;
        }else {
            hasInited.set(true);
        }

        mDataLoading.setValue(false);
        mErrorState.setValue(false);

    }

    public void onRefresh(){
        fetch(true);
    }

    public void fetch(boolean forceUpdate){
        mDataLoading.setValue(true);
        mTrendingLiveData.setValue(new ArrayList<>());
        mDataSource.getTrendsFromeRemote()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<TrendBody>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);

                    }

                    @Override
                    public void onNext(List<TrendBody> list) {
                        mTrendingLiveData.setValue(list);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDataLoading.setValue(false);
                        mErrorState.setValue(true);
                    }

                    @Override
                    public void onComplete() {
                        mDataLoading.setValue(false);
                    }
                });

    }


    public LiveData<Boolean> getDataLoading() {
        return mDataLoading;
    }

    public MutableLiveData<Boolean> getErrorState() {
        return mErrorState;
    }

    public MutableLiveData<List<TrendBody>>getmTrendingLiveData(){
        return mTrendingLiveData;
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        if (mDisposable != null) {
            mDisposable.clear();
            mDisposable = null;
        }
    }

}
