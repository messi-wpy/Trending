package com.example.trending.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.trending.R;
import com.example.trending.TrendingContract;
import com.example.trending.viewmodel.TrendingViewModel;
import com.example.trending.viewmodel.TrendingViewModelFactory;
import com.example.trending.databinding.ActivityMainBinding;
import com.example.trending.model.TrendBody;
import com.example.trending.presenter.TrendingPresenter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements TrendingContract.View {

    public static final int REQUEST_PERMISSION = 1000;

    private Toolbar mToolbar;
    private TrendingAdapter adapter;
    private RecyclerView recyclerView;
    private TrendingPresenter presenter;

    private TrendingViewModel mTrendingViewModel;
    private TrendingAdapter mAdapter;
    private ActivityMainBinding mViewBinding;
    TrendingViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mTrendingViewModel=ViewModelProviders.of(this,mViewModelFactory).get(TrendingViewModel.class);
        mViewBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);
        mViewBinding.setViewModel(mTrendingViewModel);
        mViewBinding.setLifecycleOwner(this);
        mTrendingViewModel.initData();


        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setupView();

        mTrendingViewModel.getmTrendingLiveData()
                .observe(this,list -> {
                    mAdapter.setList(list);
                });

    }

    public void setupView(){

        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

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
        adapter.addAll(list);
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
