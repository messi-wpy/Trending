package com.example.trending.model.localRepository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.trending.model.TrendBody;

@Database(entities = {TrendBody.class},version = 1)
public abstract class MyRoomDatabase extends RoomDatabase {
    public abstract TrendDao getTrendDao();
    private static MyRoomDatabase SINGLE;
    public static MyRoomDatabase getInstance(Context context){
        if (SINGLE==null){
            synchronized (MyRoomDatabase.class){
                if (SINGLE==null){
                    SINGLE= Room.databaseBuilder(context.getApplicationContext(),MyRoomDatabase.class,"Trendbs")
                            .build();
                }

            }
        }
        return SINGLE;
    }


}
