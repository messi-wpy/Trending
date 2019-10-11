package com.example.trending.model.localRepository;

import androidx.room.Insert;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Maybe;

public interface LocalSource {

    Maybe<List<TrendBody>>getAllTrend();
    Maybe<List<Long>>saveTrends(List<TrendBody>list);
}
