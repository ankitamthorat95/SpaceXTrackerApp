package com.example.spacextrackerapp.database.dao;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import com.example.spacextrackerapp.model.Favorite;

@Dao
public interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void addData(Favorite favorite);

    @Delete
    public void delete(Favorite favorite);

    @Query("DELETE FROM launches")
    void deleteAll();

    @Transaction
    @Query("SELECT EXISTS (SELECT 1 FROM FAVORITELIST WHERE flightNumber=:id)")
    public int isFavorite(int id);
}
