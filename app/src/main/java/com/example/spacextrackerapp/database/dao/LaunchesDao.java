package com.example.spacextrackerapp.database.dao;


import androidx.room.*;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import androidx.lifecycle.LiveData;

import com.example.spacextrackerapp.model.FlightItemDetails;

import java.util.List;

@Dao
public interface LaunchesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(List<FlightItemDetails> cats);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(List<FlightItemDetails> cats);

    @Query("SELECT DISTINCT * FROM launches")
    LiveData<List<FlightItemDetails>> getAllLaunches();

    @Query("DELETE FROM launches")
    void deleteAll();

}
