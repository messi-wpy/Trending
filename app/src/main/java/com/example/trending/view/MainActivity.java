package com.example.trending.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.trending.R;
import com.example.trending.TrendingContract;

public class MainActivity extends AppCompatActivity implements TrendingContract.View {

    public static final int REQUEST_PERMISSION = 1000;

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
