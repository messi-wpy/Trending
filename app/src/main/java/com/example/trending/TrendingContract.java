package com.example.trending;

import com.example.trending.model.TrendBody;

import java.util.List;

public interface TrendingContract {

    interface View{

        void showLoadingView();
        void showTrending(List<TrendBody>list);
        void showTrendingDetails();
        void showErrorView();
        void showEmptyView();

    }

    interface Presenter{
        void loadTrending();
        void loadTrendingDetails();
        void destroy();
    }
}
