package com.example.trending.model.localRepository;

import androidx.room.Insert;
import androidx.room.Query;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Maybe;

public interface TrendDao {

    @Query("select *from trend_table")
    Maybe<List<TrendBody>>getAllTrend();

    @Insert
    Maybe<List<Long>>saveTrends(List<TrendBody>list);

}
