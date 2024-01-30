package com.example.spacextrackerapp.repositories;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import com.example.spacextrackerapp.database.AppDatabase;
import com.example.spacextrackerapp.database.dao.FavoriteDao;
import com.example.spacextrackerapp.database.dao.LaunchesDao;
import com.example.spacextrackerapp.model.Favorite;
import com.example.spacextrackerapp.model.FlightItemDetails;

import java.util.List;

public class LaunchesRepository {
    public LaunchesDao launchesDao;
    public FavoriteDao favouriteDao;
    public LiveData<List<FlightItemDetails>> getAllLaunches;
    private AppDatabase database;

    public LaunchesRepository(Application application){
        database=AppDatabase.getInstance(application);
        launchesDao=database.launchesDao();
        favouriteDao = database.favouriteDao();
        getAllLaunches=launchesDao.getAllLaunches();
    }

    public LiveData<List<FlightItemDetails>> getAllLaunches(){
        return launchesDao.getAllLaunches();
    }

    public void insert(List<FlightItemDetails> launches){
        new InsertAsyncTask(launchesDao).execute(launches);
    }

    public void addFavorite(Favorite favorite){
        new AddFavAsyncTask(favouriteDao).execute(favorite);
    }

    public void removeFavorite(Favorite favorite) {
        new RemoveFavAsyncTask(favouriteDao).execute(favorite);
    }

    public boolean isFavourite(int flightId){
        return favouriteDao.isFavorite(flightId) == 1;
    }



    private static class InsertAsyncTask extends AsyncTask<List<FlightItemDetails>,Void,Void> {
        private LaunchesDao launchesDao;

        public InsertAsyncTask(LaunchesDao launchesDao)
        {
            this.launchesDao=launchesDao;
        }
        @Override
        protected Void doInBackground(List<FlightItemDetails>... lists) {
            launchesDao.insert(lists[0]);
            return null;
        }
    }


    private static class AddFavAsyncTask extends AsyncTask<Favorite,Void,Void> {
       private FavoriteDao favoriteDao;

        public AddFavAsyncTask(FavoriteDao favoriteDao)
        {
            this.favoriteDao=favoriteDao;
        }

        @Override
        protected Void doInBackground(Favorite... favorites) {
            favoriteDao.addData(favorites[0]);
            return null;
        }
    }

    private class RemoveFavAsyncTask extends AsyncTask<Favorite,Void,Void> {
        private FavoriteDao favoriteDao;

        public RemoveFavAsyncTask(FavoriteDao favouriteDao) {
            this.favoriteDao=favoriteDao;
        }

        @Override
        protected Void doInBackground(Favorite... favorites) {
            favoriteDao.delete(favorites[0]);
            return null;
        }
    }
}
