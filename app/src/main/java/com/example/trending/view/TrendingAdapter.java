package com.example.trending.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trending.R;
import com.example.trending.viewmodel.TrendingViewModel;
import com.example.trending.model.TrendBody;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.TrendingHolder> {


    private List<TrendBody>list;

    private TrendingViewModel mViewModel;
    public TrendingAdapter(TrendingViewModel viewModel){
        mViewModel=viewModel;
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


        holder.mtvDes.setText(list.get(position).getDescription());
        holder.mtvLang.setText(list.get(position).getLanguage());
        holder.mtvStars.setText(String.valueOf(list.get(position).getStars()));
        holder.mtvForks.setText(String.valueOf(list.get(position).getForks()));

        if (!list.get(position).isExpand()) {
            holder.mtvDes.setVisibility(View.GONE);
            holder.mLinear.setVisibility(View.GONE);
        }else {
            holder.mLinear.setVisibility(View.VISIBLE);
            holder.mtvDes.setVisibility(View.VISIBLE);
        }

        holder.itemView.setOnClickListener(v -> {
            if (!list.get(position).isExpand()){
                list.get(position).setExpand(true);

            }else {
                list.get(position).setExpand(false);

            }
        notifyItemChanged(position);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class TrendingHolder extends RecyclerView.ViewHolder{

        SimpleDraweeView draweeView;
        TextView tvAuthor;
        TextView tvRepository;
        LinearLayout mLinear;
        TextView mtvDes;
        TextView mtvLang;
        TextView mtvStars;
        TextView mtvForks;

        View itemView;
        public TrendingHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView=itemView;
            draweeView=itemView.findViewById(R.id.sdv_image);
            tvAuthor=itemView.findViewById(R.id.author_name);
            tvRepository=itemView.findViewById(R.id.repository_name);

            mtvDes=itemView.findViewById(R.id.item_desc);
            mtvLang=itemView.findViewById(R.id.lang_tv);
            mtvStars=itemView.findViewById(R.id.starts_tv);
            mtvForks=itemView.findViewById(R.id.forks_tv);
            mLinear=itemView.findViewById(R.id.linear);


        }
    }
}
