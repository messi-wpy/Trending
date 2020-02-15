package com.example.trending.model.localRepository;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.trending.model.TrendBody;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Maybe;
@Dao
public interface TrendDao {

    @Query("select *from trend_table")
    Maybe<List<TrendBody>>getAllTrend();

    @Insert
    List<Long>saveTrends(List<TrendBody>list);

    @Query("delete from trend_table")
    void deleteAll();


}
