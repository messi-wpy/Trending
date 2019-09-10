package com.example.trending;

public interface TrendingContract {

    interface View{

        void showLoadingView();
        void showTrending();
        void showTrendingDetails();
        void showErrorView();

    }

    interface Presenter{
        void loadTrending();
        void loadTrendingDetails();
    }
}
