package com.example.trending;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingHolder> {


    @NonNull
    @Override
    public TrendingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_list_item,parent,false);

        return new TrendingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class TrendingHolder extends RecyclerView.ViewHolder{

        public TrendingHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
