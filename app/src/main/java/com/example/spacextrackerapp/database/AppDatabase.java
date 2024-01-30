package com.example.spacextrackerapp.database;


import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;

import com.example.spacextrackerapp.database.dao.FavoriteDao;
import com.example.spacextrackerapp.database.dao.LaunchesDao;
import com.example.spacextrackerapp.model.Favorite;
import com.example.spacextrackerapp.model.FlightItemDetails;

@Database(entities = {FlightItemDetails.class, Favorite.class},version = 5,exportSchema = false)
@TypeConverters({LaunchConverter.class})
public abstract class AppDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "SpacexLaunchesDatabase";
    public abstract LaunchesDao launchesDao();
    public abstract FavoriteDao favouriteDao();
    public static volatile AppDatabase INSTANCE = null;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .addCallback(callback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    public static Callback callback = new Callback() {
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            new PopulateDbAsyn(INSTANCE);
        }
    };

    static  class  PopulateDbAsyn extends AsyncTask<Void,Void,Void> {
        private LaunchesDao launchesDao;
        public PopulateDbAsyn(AppDatabase appDatabase)
        {
            launchesDao=appDatabase.launchesDao();
        }
        @Override
        protected Void doInBackground(Void... voids) {
            launchesDao.deleteAll();
            return null;
        }
    }
}
