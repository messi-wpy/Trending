package com.example.trending.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.trending.DI.DaggerAppComponent;
import com.example.trending.R;
import com.example.trending.TrendingContract;
import com.example.trending.viewmodel.TrendingViewModel;
import com.example.trending.viewmodel.TrendingViewModelFactory;
import com.example.trending.databinding.ActivityMainBinding;
import com.example.trending.model.TrendBody;

import java.util.List;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class MainActivity extends DaggerAppCompatActivity implements TrendingContract.View {

    public static final int REQUEST_PERMISSION = 1000;

    private Toolbar mToolbar;
    private RecyclerView recyclerView;

    private TrendingViewModel mTrendingViewModel;
    private TrendingAdapter mAdapter;
    private ActivityMainBinding mViewBinding;

    @Inject
    TrendingViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //   Log.i("test", "onCreate: "+mViewModelFactory);
        mTrendingViewModel=ViewModelProviders.of(this,mViewModelFactory).get(TrendingViewModel.class);
        mViewBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewBinding.setViewModel(mTrendingViewModel);
        mViewBinding.setLifecycleOwner(this);



        setupView();
        mTrendingViewModel.initData();

        mTrendingViewModel.getmTrendingLiveData()
                .observe(this,list -> {
                    mAdapter.setList(list);
                });

    }

    public void setupView(){

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");

        recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter=new TrendingAdapter(mTrendingViewModel);
        recyclerView.setAdapter(mAdapter);


    }


    @Override
    public void showLoadingView() {

    }

    @Override
    public void showTrending(List<TrendBody> list) {
    }


    @Override
    public void showTrendingDetails() {

    }

    @Override
    public void showErrorView() {

    }

    @Override
    public void showEmptyView() {

    }


}
