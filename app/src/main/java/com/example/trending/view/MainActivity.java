package com.example.trending.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.trending.R;
import com.example.trending.TrendingContract;

public class MainActivity extends AppCompatActivity implements TrendingContract.View {

    private Toolbar mToolbar;
    private TrendingAdapter adapter;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar=findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setTitle("");
        recyclerView=findViewById(R.id.recyclerView);
        adapter=new TrendingAdapter();
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void showLoadingView() {

    }

    @Override
    public void showTrending() {

    }

    @Override
    public void showTrendingDetails() {

    }

    @Override
    public void showErrorView() {

    }


}
