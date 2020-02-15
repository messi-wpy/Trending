package com.example.trending.model.localRepository;

import androidx.room.Insert;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;

public interface LocalSource {

    Maybe<List<TrendBody>>getAllTrend();
    Completable saveTrends(List<TrendBody>list);
}
