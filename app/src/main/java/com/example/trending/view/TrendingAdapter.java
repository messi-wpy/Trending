package com.example.trending.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.R;
import com.example.trending.model.TrendBody;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingHolder> {


    private List<TrendBody>list;
    public TrendingAdapter(List<TrendBody>list){
        list=list;
    }

    public void setList(List<TrendBody>newlist){
        list=newlist;
        notifyDataSetChanged();
    }
    public void add(TrendBody trendBody){
        list.add(trendBody);
        notifyDataSetChanged();
    }

    public void addAll(List<TrendBody>add){
        list.addAll(add);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public TrendingHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.trending_list_item,parent,false);


        return new TrendingHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TrendingHolder holder, int position) {
        holder.draweeView.setImageURI(list.get(position).getAvatar());
        holder.tvAuthor.setText(list.get(position).getAuthor());
        holder.tvRepository.setText(list.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TrendingHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView draweeView;
        TextView tvAuthor;
        TextView tvRepository;
        public TrendingHolder(@NonNull View itemView) {
            super(itemView);
            draweeView=itemView.findViewById(R.id.sdv_image);
            tvAuthor=itemView.findViewById(R.id.author_name);
            tvRepository=itemView.findViewById(R.id.repository_name);

        }
    }
}
